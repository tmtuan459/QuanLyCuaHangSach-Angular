package com.quanlysach.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlysach.entities.PhieuXuatEntity;
import com.quanlysach.entities.SachEntity;
import com.quanlysach.payload.request.PhieuXuatRequest;
import com.quanlysach.repositories.ChiTietPhieuXuatRepository;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.services.impl.PhieuXuatChiTietService;
import com.quanlysach.services.impl.PhieuXuatService;

/**
 * PhieuXuatController
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
@RequestMapping("/api/v1/export")
public class PhieuXuatController {
	@Autowired
	private PhieuXuatService phieuXuatService;
	@Autowired
	private PhieuXuatChiTietService chiTietPXService;
	@Autowired
	private SachRepository sachRepository;
	@Autowired
	private ChiTietPhieuXuatRepository chiTietPhieuXuatR;

	/**
	 * create new export
	 * 
	 * @param list
	 * @return export
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createExport(@RequestBody List<PhieuXuatRequest> list) {
		try {
			for (PhieuXuatRequest px : list) {
				SachEntity sach = sachRepository.findByTenSach(px.getTensach());
				if (sach.isDeleteFlag() == true) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				} else if (px.getSoLuong() > sach.getSoLuong()) {
					return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
				} else if (px.getTenNguoiNhan() == "" || px.getDiaChi() == "" || px.getSoDienThoai() == ""
						|| px.getTenNguoiNhan() == null || px.getDiaChi() == null || px.getSoDienThoai() == null) {
					return new ResponseEntity<>(HttpStatus.LOCKED);
				}
			}
			
			PhieuXuatEntity phieuXuatEntity = phieuXuatService.createPhieuXuat(list);
			chiTietPXService.addPhieuXuatChiTiet(list, phieuXuatEntity);
			return ResponseEntity.ok(chiTietPXService);
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * get list details export
	 * 
	 * @return list details export
	 */
	@GetMapping("/listDetails")
	public ResponseEntity<Object> listDetailExport() {
		try {
			return ResponseEntity.ok(chiTietPhieuXuatR.ListChiTietDonXuat());
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
