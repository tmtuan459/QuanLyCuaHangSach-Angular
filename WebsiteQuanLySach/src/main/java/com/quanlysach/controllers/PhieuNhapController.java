package com.quanlysach.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlysach.entities.PhieuNhapEntity;
import com.quanlysach.entities.SachEntity;
import com.quanlysach.payload.request.PhieuNhapRequest;
import com.quanlysach.repositories.ChiTietPhieuNhapRepository;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.services.impl.PhieuNhapChiTietService;
import com.quanlysach.services.impl.PhieuNhapService;

/**
 * PhieuNhapController
 * 
 * Version 1.0
 * 
 * Date 19-08-2021
 * 
 * Modification Logs:
 * 
 * * DATE AUTHOR DESCRIPTION 
 * -------------------------
 * 
 * 17-09-2021 TuanTM24 Create
 */
@CrossOrigin(origins = "http://localhost:4200") // fix block by CORS
@RestController
@RequestMapping("/api/v1/import")
public class PhieuNhapController {
	@Autowired
	private PhieuNhapService phieuNhapService;
	@Autowired
	private PhieuNhapChiTietService chiTietPNService;
	@Autowired
	private SachRepository sachRepository;
	@Autowired
	private ChiTietPhieuNhapRepository chiTietPhieuNhapR;

	/**
	 * create new imporrt
	 * 
	 * @param list
	 * @return import
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createImport(@Valid @RequestBody List<PhieuNhapRequest> list) {
		try {
			for (PhieuNhapRequest px : list) {
				// find book by name
				SachEntity sach = sachRepository.findByTenSach(px.getTensach());
				// check delete flag
				if (sach.isDeleteFlag() == true) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

			PhieuNhapEntity phieuNhapEntity = phieuNhapService.createPhieuNhap();
			chiTietPNService.addPhieuNhapChiTiet(list, phieuNhapEntity);
			return ResponseEntity.ok(chiTietPNService);
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * get list details import
	 * 
	 * @return list import details
	 */
	@GetMapping("/listDetails")
	public ResponseEntity<Object> listDetailImport() {
		try {
			return ResponseEntity.ok(chiTietPhieuNhapR.ListChiTietDonNhap());
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
