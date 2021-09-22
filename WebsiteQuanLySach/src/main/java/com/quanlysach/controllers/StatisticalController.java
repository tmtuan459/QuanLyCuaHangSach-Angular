package com.quanlysach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.repositories.ExportDetailRepository;

/**
 * ThongKeController
 * 
 * Version 1.0
 * 
 * Date 19-08-2021
 * 
 * Modification Logs:
 * 
 * * DATE AUTHOR DESCRIPTION 
 * --------------------------
 * 
 * 17-09-2021 TuanTM24 Create
 */
@CrossOrigin(origins = "http://localhost:4200") // fix block by CORS
@RestController
@RequestMapping("/api/v1/statistical")
public class StatisticalController {

	@Autowired
	private ExportDetailRepository ctpxrepository;
	
	/**
	 * get revenue by month
	 * @return list 
	 */
	@GetMapping("/Revenue")
	public ResponseEntity<Object> listAll() {
		try {
			return ResponseEntity.ok(ctpxrepository.ListExport());
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}
	
	/**
	 * get list revenue by book
	 * @return list
	 */
	@GetMapping("/RevenueByBook")
	public ResponseEntity<Object> listRevenueByBook() {
		try {
			return ResponseEntity.ok(ctpxrepository.ListRevenueByBook());
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}
	}
}
