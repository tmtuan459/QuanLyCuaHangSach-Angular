package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.TypeEntity;
import com.quanlysach.payload.request.TypeRequest;
import com.quanlysach.payload.request.TypeUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.TypeRespone;
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
public interface IType {
	/**
	 * create The Loai
	 * @param theLoaiRequest
	 * @return
	 */
	TypeEntity createType(TypeRequest typeRequest);
	
	/**
	 * edit The Loai
	 * @param theLoaiUpdateRequest
	 * @return
	 */
	MessageRespone editType (TypeUpdateRequest typeUpdateRequest);
	
	/**
	 * find By Id Type
	 * @param Id
	 * @return
	 */
	TypeRespone findByIdType(Long Id);
	
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
	List<TypeRespone> findAllByDeleteFlagFalse();

}
