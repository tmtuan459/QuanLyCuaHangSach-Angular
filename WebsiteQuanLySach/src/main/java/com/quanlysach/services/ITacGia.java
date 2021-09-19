package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.TacGiaEntity;
import com.quanlysach.payload.request.TacGiaRequest;
import com.quanlysach.payload.request.TacGiaUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.TacGiaRespone;
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
public interface ITacGia {
	/**
	 * create Author
	 * @param tacGiaRequest
	 * @return
	 */
	TacGiaEntity createAuthor(TacGiaRequest tacGiaRequest);
	
	/**
	 * edit Author
	 * @param tacGiaUpdateRequest
	 * @return
	 */
	MessageRespone editAuthor (TacGiaUpdateRequest tacGiaUpdateRequest);
	
	/**
	 * find All Author By Delete Flag False
	 * @return
	 */
	List<TacGiaRespone> findAllByDeleteFlagFalse();
	
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
	TacGiaRespone findByIdAuthor( Long Id);
}
