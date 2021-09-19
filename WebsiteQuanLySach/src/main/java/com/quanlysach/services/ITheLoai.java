package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.TheLoaiEntity;
import com.quanlysach.payload.request.TheLoaiRequest;
import com.quanlysach.payload.request.TheLoaiUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.TheLoaiRespone;
/**
 * Interface The Loai
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
public interface ITheLoai {
	/**
	 * create The Loai
	 * @param theLoaiRequest
	 * @return
	 */
	TheLoaiEntity createTheLoai(TheLoaiRequest theLoaiRequest);
	
	/**
	 * edit The Loai
	 * @param theLoaiUpdateRequest
	 * @return
	 */
	MessageRespone editTheLoai (TheLoaiUpdateRequest theLoaiUpdateRequest);
	
	/**
	 * find By Id Type
	 * @param Id
	 * @return
	 */
	TheLoaiRespone findByIdType(Long Id);
	
	/**
	 * toggle Delete Flag By Id
	 * @param id
	 * @return
	 */
	MessageRespone toggleDeleteFlagById(Long id);
	
	/**
	 * findAll By Delete Flag False
	 * @return
	 */
	List<TheLoaiRespone> findAllByDeleteFlagFalse();

}
