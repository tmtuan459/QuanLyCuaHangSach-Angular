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

import com.quanlysach.entities.BookEntity;
import com.quanlysach.payload.request.BookRequest;
import com.quanlysach.payload.request.BookUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.repositories.AuthorRepository;
import com.quanlysach.repositories.TypeRepository;
import com.quanlysach.services.IBook;

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
public class BookController {

	private IBook bookService;
	private BookRepository bookRepository;
	private TypeRepository typeRepository;
	private AuthorRepository authorRepository;
	
	//muốn inject 3 bean trở lên vào 1 class nen lam nhu nay
	@Autowired
	BookController(IBook bookService,BookRepository bookRepository,TypeRepository typeRepository,AuthorRepository authorRepository) {
		this.bookService = bookService;
		this.bookRepository = bookRepository;
		this.typeRepository = typeRepository;
		this.authorRepository = authorRepository;
	}
	
	/**
	 * get list book deleteflag true
	 * 
	 * @return list book
	 */
	@GetMapping("/listAllByEnable")
	public ResponseEntity<Object> listAllBookDeleteFlagTrue() {
		try {
			return ResponseEntity.ok(bookService.findAllByDeleteFlagTrue());
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
			return ResponseEntity.ok(bookService.findAllByDeleteFlagFalse());
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
			return ResponseEntity.ok(bookService.listBookInsufficient());
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
			return ResponseEntity.ok(bookService.listBookRedundant());
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
	public ResponseEntity<Object> createBook(@RequestBody @Valid BookRequest bookRequest) {

		try {
			if (bookRepository.findByNameBook(bookRequest.getTensach()) != null) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(bookService.createBook(bookRequest));
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
	public ResponseEntity<Object> editBook(@RequestBody @Valid BookUpdateRequest bookUpdateRequest) {
		try {
			BookEntity book = bookRepository.findOne(bookUpdateRequest.getId());
			
			// has delete flag true
			if (book.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(bookService.editBook(bookUpdateRequest));
			
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
			BookEntity book = bookRepository.findOne(id);

			if (book.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return ResponseEntity.ok(bookService.toggleDeleteFlagById(id));
			
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
			BookEntity book = bookRepository.findOne(id);
			
			if (book.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(bookService.findByIdBook(id));
			
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
			BookEntity book = bookRepository.findByNameBook(name);
			
			if (book.isDeleteFlag() == true) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return ResponseEntity.ok(bookService.findByIdBook(book.getId()));
			
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
			return ResponseEntity.ok(bookRepository.findBookByAuthor(id));
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
			return ResponseEntity.ok(bookRepository.findBookByType(id));
		} catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageRespone("Sorry, we have an error! Please login and try again"));
		}

	}

}
