package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.PhieuNhapEntity;
import com.quanlysach.payload.respone.PhieuNhapRespone;
/**
 * Interface Phieu Nhap
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
public interface IPhieuNhap {
	/**
	 * get All phieu nhap
	 * @return
	 */
	List<PhieuNhapRespone> getAllPN();
	
	/**
	 * get Phieu nhap By Id
	 * @param id
	 * @return
	 */
	PhieuNhapRespone getById(Long id);
	
	/**
	 * add Phieu Nhap
	 * @param phieuNhapEntity
	 */
	void addPhieuNhap(PhieuNhapEntity phieuNhapEntity);
	
	/**
	 * create Phieu Nhap
	 * @return
	 */
	PhieuNhapEntity createPhieuNhap();
	
	/**
	 * get Phieu Nhap Last
	 * @return
	 */
	PhieuNhapRespone getPhieuNhapLast();
}
