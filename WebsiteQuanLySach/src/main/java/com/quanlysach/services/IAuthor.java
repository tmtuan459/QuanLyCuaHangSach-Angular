package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.AuthorEntity;
import com.quanlysach.payload.request.AuthorRequest;
import com.quanlysach.payload.request.AuthorUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.AuthorRespone;
/**
 * Interface Tac Gia
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
public interface IAuthor {
	/**
	 * create Author
	 * @param tacGiaRequest
	 * @return
	 */
	AuthorEntity createAuthor(AuthorRequest authorRequest);
	
	/**
	 * edit Author
	 * @param tacGiaUpdateRequest
	 * @return
	 */
	MessageRespone editAuthor (AuthorUpdateRequest authorUpdateRequest);
	
	/**
	 * find All Author By Delete Flag False
	 * @return
	 */
	List<AuthorRespone> findAllByDeleteFlagFalse();
	
	/**
	 * toggle Delete Flag By Id
	 * @param id
	 * @return
	 */
	MessageRespone toggleDeleteFlagById(Long id);
	
	/**
	 * find By Id Author
	 * @param Id
	 * @return
	 */
	AuthorRespone findByIdAuthor( Long Id);
}
