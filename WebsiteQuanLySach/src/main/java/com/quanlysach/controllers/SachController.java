package com.quanlysach.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlysach.entities.SachEntity;
import com.quanlysach.payload.request.SachRequest;
import com.quanlysach.payload.request.SachUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.repositories.TacGiaRepository;
import com.quanlysach.repositories.TheLoaiRepository;
import com.quanlysach.services.ISach;

/**
 * SachController
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
@RequestMapping("/api/v1/book")
public class SachController {

	@Autowired
	private ISach sachService;

	@Autowired
	private SachRepository sachRepository;
	@Autowired
	private TheLoaiRepository theLoaiRepository;
	@Autowired
	private TacGiaRepository tacGiaRepository;

	/**
	 * get list book deleteflag true
	 * 
	 * @return list book
	 */
	@GetMapping("/listAllByEnable")
	public ResponseEntity<Object> listAllBookDeleteFlagTrue() {
		try {
			return ResponseEntity.ok(sachService.findAllByDeleteFlagTrue());
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

	/**
	 * get list book deleteflag false
	 * 
	 * @return list book
	 */
	@GetMapping("/listAllByDisable")
	public ResponseEntity<Object> listAllBookDeleteFlagFalse() {
		try {
			return ResponseEntity.ok(sachService.findAllByDeleteFlagFalse());
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

	/**
	 * get list book insufficient
	 * 
	 * @return list book insufficient
	 */
	@GetMapping("/listBookInsufficient")
	public ResponseEntity<Object> listBookInsufficient() {
		try {
			return ResponseEntity.ok(sachService.listBookInsufficient());
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

	/**
	 * get list book redundant
	 * 
	 * @return list book redundant
	 */
	@GetMapping("/listBookRedundant")
	public ResponseEntity<Object> listBookRedundant() {
		try {
			return ResponseEntity.ok(sachService.listBookRedundant());
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

	/**
	 * create new book
	 * 
	 * @param sachRequest
	 * @return book
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createBook(@RequestBody @Valid SachRequest sachRequest) {

		try {
			if (sachRepository.findByTenSach(sachRequest.getTensach()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(sachService.createSach(sachRequest));
		} catch (NullPointerException e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	/**
	 * update infomate of book
	 * 
	 * @param sachUpdateRequest
	 * @return book
	 */
	@PutMapping("/edit")
	public ResponseEntity<Object> editBook(@RequestBody @Valid SachUpdateRequest sachUpdateRequest) {
		try {
			SachEntity sach = sachRepository.findOne(sachUpdateRequest.getId());
			
			// has delete flag true
			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(sachService.editSach(sachUpdateRequest));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * delete logic book
	 * 
	 * @param id
	 * @return status
	 */
	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<Object> deleteBook(@PathVariable("ID") Long id) {
		try {
			SachEntity sach = sachRepository.findOne(id);

			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return ResponseEntity.ok(sachService.toggleDeleteFlagById(id));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * find book by id
	 * 
	 * @param id
	 * @return book
	 */
	@GetMapping("/findById/{ID}")
	public ResponseEntity<Object> FINDBYID(@PathVariable("ID") Long id) {
		try {
			SachEntity sach = sachRepository.findOne(id);
			
			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(sachService.findByIdBook(id));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * find book by name of book
	 * 
	 * @param id
	 * @return book
	 */
	@GetMapping("/findByName/{NAME}")
	public ResponseEntity<Object> FINDBYName(@PathVariable("NAME") String name) {
		try {
			SachEntity sach = sachRepository.findByTenSach(name);
			
			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(sachService.findByIdBook(sach.getId()));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * get list book by name of author
	 * 
	 * @param id
	 * @return list book
	 */
	@GetMapping("/listBookByAuthor/{ID}")
	public ResponseEntity<Object> listBooKByAuthor(@PathVariable("ID") Long id) {
		try {
			return ResponseEntity.ok(sachRepository.findBookByAuthor(id));
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

	/**
	 * list book by type
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/listBookByType/{ID}")
	public ResponseEntity<Object> listBooKByType(@PathVariable("ID") Long id) {
		try {
			return ResponseEntity.ok(sachRepository.findBookByType(id));
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

}
