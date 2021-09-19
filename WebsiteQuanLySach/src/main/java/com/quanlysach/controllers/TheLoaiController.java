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

import com.quanlysach.entities.SachEntity;
import com.quanlysach.entities.TheLoaiEntity;
import com.quanlysach.payload.request.TheLoaiRequest;
import com.quanlysach.payload.request.TheLoaiUpdateRequest;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.repositories.TheLoaiRepository;
import com.quanlysach.services.ITheLoai;

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
public class TheLoaiController {

	@Autowired
	private ITheLoai theLoaiService;
	@Autowired
	private TheLoaiRepository theLoaiRepository;
	@Autowired
	private SachRepository sachRepository;

	/**
	 * 
	 * @param theLoaiRequest
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createType(@RequestBody @Valid TheLoaiRequest theLoaiRequest) {
		try {
			if (theLoaiRepository.findByTenTheLoai(theLoaiRequest.getTenTheLoai()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return ResponseEntity.ok(theLoaiService.createTheLoai(theLoaiRequest));
			
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
			return ResponseEntity.ok(theLoaiService.findAllByDeleteFlagFalse());
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
	public ResponseEntity<Object> editTheLoai(@RequestBody @Valid TheLoaiUpdateRequest theLoaiUpdateRequest) {
		try {
			TheLoaiEntity theLoai = theLoaiRepository.findOne(theLoaiUpdateRequest.getId());

			if ((theLoai.isDeleteFlag() == true)) {
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);// da xoa' -err 501
			}

			return ResponseEntity.ok(theLoaiService.editTheLoai(theLoaiUpdateRequest));
			
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
			TheLoaiEntity sach = theLoaiRepository.findOne(id);
			List<SachEntity> list = sachRepository.findBookByType(id);
			
			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(list.size()>0) {
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
			}else {
				return ResponseEntity.ok(theLoaiService.toggleDeleteFlagById(id));
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
	public ResponseEntity<Object> FINDBYID(@PathVariable("ID") Long id) {
		try {
			TheLoaiEntity sach = theLoaiRepository.findOne(id);
			
			if (sach.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(theLoaiService.findByIdType(id));
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
