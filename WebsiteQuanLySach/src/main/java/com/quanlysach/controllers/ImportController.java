package com.quanlysach.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlysach.entities.ImportEntity;
import com.quanlysach.entities.BookEntity;
import com.quanlysach.payload.request.ImportRequest;
import com.quanlysach.repositories.ImportDetailRepository;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.services.impl.ImportDetailService;
import com.quanlysach.services.impl.ImportService;

/**
 * PhieuNhapController
 * 
 * Version 1.0
 * 
 * Date 19-08-2021
 * 
 * Modification Logs:
 * 
 * * DATE AUTHOR DESCRIPTION -------------------------
 * 
 * 17-09-2021 TuanTM24 Create
 */
@CrossOrigin(origins = "http://localhost:4200") // fix block by CORS
@RestController
@RequestMapping("/api/v1/import")
public class ImportController {

	Logger logger = LoggerFactory.getLogger(ImportController.class);

	// khoong nen @autowired tung cai, Nên sử dụng dependency injection tại
	// constructor để đảm bảo performance
	// và lỗi duplicated dependency injection và dễ làm unit test khi muốn inject 3
	// bean trở lên vào 1 class

	private ImportService importService;
	private ImportDetailService importDetailService;
	private BookRepository bookRepository;
	private ImportDetailRepository importDetailR;

	@Autowired
	ImportController(ImportService importService, ImportDetailService importDetailService,
			BookRepository bookRepository, ImportDetailRepository importDetailR) {
		this.importService = importService;
		this.importDetailService = importDetailService;
		this.bookRepository = bookRepository;
		this.importDetailR = importDetailR;

	}

	/**
	 * create new imporrt
	 * 
	 * @param list
	 * @return import
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createImport(@Valid @RequestBody List<ImportRequest> list) {

		try {
			for (ImportRequest px : list) {
				// find book by name
				BookEntity sach = bookRepository.findByNameBook(px.getTensach());
				// check delete flag
				if (sach.isDeleteFlag() == true) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

				}
				logger.error("Error");
			}

			ImportEntity importEntity = importService.createImport();
			importDetailService.addImportDetail(list, importEntity);
			return ResponseEntity.ok(importDetailService);

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

		Optional<?> result = Optional.ofNullable(importDetailR.ListImportDetail());
		if (result.isPresent()) {
			return ResponseEntity.ok(importDetailR.ListImportDetail());
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
//		Optional<?> result = Optional.ofNullable(importDetailR.ListImportDetail());
//		return result.map(() -> ResponseEntity.ok(importDetailR.ListImportDetail))
//				.orElse(() -> {new ResponseEntity<>(HttpStatus.BAD_REQUEST)});
						
	}
}
