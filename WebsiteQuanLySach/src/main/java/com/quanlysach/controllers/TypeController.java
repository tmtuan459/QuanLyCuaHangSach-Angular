package com.quanlysach.controllers;

import java.util.List;

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

import com.quanlysach.entities.BookEntity;
import com.quanlysach.entities.TypeEntity;
import com.quanlysach.payload.request.TypeRequest;
import com.quanlysach.payload.request.TypeUpdateRequest;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.repositories.TypeRepository;
import com.quanlysach.services.IType;

/**
 * TheLoaiController
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
@RequestMapping("/api/v1/type")
public class TypeController {

	@Autowired
	private IType typeService;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private BookRepository bookRepository;

	/**
	 * 
	 * @param theLoaiRequest
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createType(@RequestBody @Valid TypeRequest typeRequest) {
		try {
			if (typeRepository.findByNameType(typeRequest.getTenTheLoai()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return ResponseEntity.ok(typeService.createType(typeRequest));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * get list all type 
	 * @return list type
	 */
	@GetMapping("/listAllByDisable")
	public ResponseEntity<Object> listAllTypeDeleteFlagFalse() {
		try {
			return ResponseEntity.ok(typeService.findAllByDeleteFlagFalse());
		} catch (NullPointerException e) {
			return ResponseEntity.ok("error!");
		}
	}

	/**
	 * update type 
	 * @param theLoaiUpdateRequest
	 * @return type
	 */
	@PutMapping("/edit")
	public ResponseEntity<Object> editType(@RequestBody @Valid TypeUpdateRequest typeUpdateRequest) {
		try {
			TypeEntity type = typeRepository.findOne(typeUpdateRequest.getId());

			if ((type.isDeleteFlag() == true)) {
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);// da xoa' -err 501
			}

			return ResponseEntity.ok(typeService.editType(typeUpdateRequest));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * delete type
	 * @param id
	 * @return status
	 */
	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<Object> deleteType(@PathVariable("ID") Long id) {
		try {
			TypeEntity book = typeRepository.findOne(id);
			List<BookEntity> list = bookRepository.findBookByType(id);
			
			if (book.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(list.size()>0) {
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
			}else {
				return ResponseEntity.ok(typeService.toggleDeleteFlagById(id));
			}
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	/**
	 * find type by id
	 * @param id
	 * @return type
	 */
	@GetMapping("/findById/{ID}")
	public ResponseEntity<Object> findByID(@PathVariable("ID") Long id) {
		try {
			TypeEntity sach = typeRepository.findOne(id);
			
			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(typeService.findByIdType(id));
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
