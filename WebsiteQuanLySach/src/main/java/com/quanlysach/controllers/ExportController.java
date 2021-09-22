package com.quanlysach.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlysach.entities.ExportEntity;
import com.quanlysach.entities.BookEntity;
import com.quanlysach.payload.request.ExportRequest;
import com.quanlysach.repositories.ExportDetailRepository;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.services.impl.ExportDetailService;
import com.quanlysach.services.impl.ExportService;

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
public class ExportController {
	
	private ExportService exportService;
	private ExportDetailService exportDetailService;
	private BookRepository bookRepository;
	private ExportDetailRepository exportDetailR;

	//muốn inject 3 bean trở lên vào 1 class nen lam nhu nay
	@Autowired
	ExportController(ExportService exportService,ExportDetailService exportDetailService, BookRepository bookRepository, ExportDetailRepository exportDetailR) {
		this.exportService=exportService;
		this.exportDetailService=exportDetailService;
		this.bookRepository=bookRepository;
		this.exportDetailR=exportDetailR;
	}
	
	/**
	 * create new export
	 * 
	 * @param list
	 * @return export
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createExport(@RequestBody List<ExportRequest> list) {
		try {
			for (ExportRequest px : list) {
				BookEntity sach = bookRepository.findByNameBook(px.getTensach());
				if (sach.isDeleteFlag() == true) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				} else if (px.getSoLuong() > sach.getSoLuong()) {
					return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
				} else if (px.getTenNguoiNhan() == "" || px.getDiaChi() == "" || px.getSoDienThoai() == ""
						|| px.getTenNguoiNhan() == null || px.getDiaChi() == null || px.getSoDienThoai() == null) {
					return new ResponseEntity<>(HttpStatus.LOCKED);
				}
			}
			
			ExportEntity exportEntity = exportService.createExport(list);
			exportDetailService.addExportDetail(list, exportEntity);
			return ResponseEntity.ok(exportDetailService);
			
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
		
		Optional<?> result = Optional.ofNullable(exportDetailR.ListExportDetailt());
		if (result.isPresent()) {
			return ResponseEntity.ok(exportDetailR.ListExportDetailt());
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		
	}

}
