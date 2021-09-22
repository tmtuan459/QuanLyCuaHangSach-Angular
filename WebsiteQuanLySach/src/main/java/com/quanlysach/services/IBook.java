package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.BookEntity;
import com.quanlysach.payload.request.BookRequest;
import com.quanlysach.payload.request.BookUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.BookRespone;
/**
 * Interface Sach
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
public interface IBook {
	
	/**
	 * create Sach
	 * @param sachRequest
	 * @return
	 */
	BookRespone createBook (BookRequest bookRequest);
	
	/**
	 * edit Sach
	 * @param sachUpdateRequest
	 * @return
	 */
	MessageRespone editBook (BookUpdateRequest bookUpdateRequest);
	
	/**
	 * find All Book By Delete Flag False
	 * @return
	 */
	List<BookEntity> findAllByDeleteFlagFalse();
	
	/**
	 * find All By Delete Flag True
	 * @return
	 */
	List<BookRespone> findAllByDeleteFlagTrue();
	
	/**
	 * list Book Insufficient
	 * @return
	 */
	List<BookRespone> listBookInsufficient();//het
	
	/**
	 * list Book Redundant
	 * @return
	 */
	List<BookRespone> listBookRedundant();//thua`
	
	/**
	 * toggle Delete Flag By Id
	 * @param id
	 * @return
	 */
	MessageRespone toggleDeleteFlagById(Long id);
	
	/**
	 * find By Id Book
	 * @param Id
	 * @return
	 */
	BookRespone findByIdBook( Long Id);

	
}
