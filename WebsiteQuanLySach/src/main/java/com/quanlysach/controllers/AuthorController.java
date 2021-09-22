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
import com.quanlysach.entities.AuthorEntity;
import com.quanlysach.payload.request.AuthorRequest;
import com.quanlysach.payload.request.AuthorUpdateRequest;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.repositories.AuthorRepository;
import com.quanlysach.services.IAuthor;

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
public class AuthorController {
	@Autowired
	private IAuthor authorService;

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * create author
	 * @param tacGiaReuqest
	 * @return new author
	 */
	@PostMapping("/create")
	public ResponseEntity<Object> createAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
		try {
			if (authorRepository.findByNameAuthor(authorRequest.getTenTacGia()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//trung ten -500
			}

			return ResponseEntity.ok(authorService.createAuthor(authorRequest));
			
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
			return ResponseEntity.ok(authorService.findAllByDeleteFlagFalse());
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
	public ResponseEntity<Object> editAuthor(@RequestBody @Valid AuthorUpdateRequest authorUpdateRequest) {
		try {
			AuthorEntity author = authorRepository.findOne(authorUpdateRequest.getId());

			if(author.isDeleteFlag()==true) {
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);//da xoa-done-501
				}

			return ResponseEntity.ok(authorService.editAuthor(authorUpdateRequest));
			
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
	public ResponseEntity<Object> deleteAuthor(@PathVariable("ID") Long id) {
		try {
			AuthorEntity author = authorRepository.findOne(id);
			List<BookEntity> list = bookRepository.findBookByAuthor(id);
			
			if (author.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(list.size()>0) {				
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
			}else {
				return ResponseEntity.ok(authorService.toggleDeleteFlagById(id));
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
			AuthorEntity author = authorRepository.findOne(id);
			
			if (author.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(authorService.findByIdAuthor(id));
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
