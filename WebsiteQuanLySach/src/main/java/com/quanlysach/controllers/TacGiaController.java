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
import com.quanlysach.entities.TacGiaEntity;
import com.quanlysach.payload.request.TacGiaRequest;
import com.quanlysach.payload.request.TacGiaUpdateRequest;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.repositories.TacGiaRepository;
import com.quanlysach.services.ITacGia;

/**
 * TacGiaController
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
@RequestMapping("/api/v1/author")
public class TacGiaController {
	@Autowired
	private ITacGia tacGiaService;

	@Autowired
	private TacGiaRepository tacGiaRepository;
	@Autowired
	private SachRepository sachRepository;
	
	/**
	 * create author
	 * @param tacGiaReuqest
	 * @return new author
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createTacGia(@RequestBody @Valid TacGiaRequest tacGiaReuqest) {
		try {
			if (tacGiaRepository.findByTenTacGia(tacGiaReuqest.getTenTacGia()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//trung ten -500
			}

			return ResponseEntity.ok(tacGiaService.createAuthor(tacGiaReuqest));
			
		} catch (NullPointerException e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}
	
	/**
	 * get list author with delete flag = false
	 * @return list author 
	 */
	@GetMapping("/listAllByDisable")
	public ResponseEntity<Object> listAllAuthorDeleteFlagFalse() {
		try {
			return ResponseEntity.ok(tacGiaService.findAllByDeleteFlagFalse());
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * update infomation of author
	 * @param tacGiaUpdateRequest
	 * @return author
	 */
	@PutMapping("/edit")
	public ResponseEntity<Object> editTacGia(@RequestBody @Valid TacGiaUpdateRequest tacGiaUpdateRequest) {
		try {
			TacGiaEntity tacGia = tacGiaRepository.findOne(tacGiaUpdateRequest.getId());

			if(tacGia.isDeleteFlag()==true) {
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);//da xoa-done-501
				}

			return ResponseEntity.ok(tacGiaService.editAuthor(tacGiaUpdateRequest));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * delete author
	 * @param id
	 * @return status
	 */
	@DeleteMapping("/delete/{ID}") // done stt
	public ResponseEntity<Object> deleteTacGia(@PathVariable("ID") Long id) {
		try {
			TacGiaEntity tacGia = tacGiaRepository.findOne(id);
			List<SachEntity> list = sachRepository.findBookByAuthor(id);
			
			if (tacGia.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(list.size()>0) {				
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
			}else {
				return ResponseEntity.ok(tacGiaService.toggleDeleteFlagById(id));
			}
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	/**
	 * find author by id
	 * @param id
	 * @return author
	 */
	@GetMapping("/findById/{ID}") // done stt
	public ResponseEntity<Object> FindAuthorById(@PathVariable("ID") Long id) {
		try {
			TacGiaEntity tacGia = tacGiaRepository.findOne(id);
			
			if (tacGia.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(tacGiaService.findByIdAuthor(id));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
