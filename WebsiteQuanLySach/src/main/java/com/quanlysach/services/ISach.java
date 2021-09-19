package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.SachEntity;
import com.quanlysach.payload.request.SachRequest;
import com.quanlysach.payload.request.SachUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.SachRespone;
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
public interface ISach {
	
	/**
	 * create Sach
	 * @param sachRequest
	 * @return
	 */
	SachRespone createSach (SachRequest sachRequest);
	
	/**
	 * edit Sach
	 * @param sachUpdateRequest
	 * @return
	 */
	MessageRespone editSach (SachUpdateRequest sachUpdateRequest);
	
	/**
	 * find All Book By Delete Flag False
	 * @return
	 */
	List<SachEntity> findAllByDeleteFlagFalse();
	
	/**
	 * find All By Delete Flag True
	 * @return
	 */
	List<SachRespone> findAllByDeleteFlagTrue();
	
	/**
	 * list Book Insufficient
	 * @return
	 */
	List<SachRespone> listBookInsufficient();//het
	
	/**
	 * list Book Redundant
	 * @return
	 */
	List<SachRespone> listBookRedundant();//thua`
	
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
	SachRespone findByIdBook( Long Id);

	
}
