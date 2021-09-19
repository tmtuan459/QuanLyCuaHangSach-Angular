package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.PhieuXuatEntity;
import com.quanlysach.payload.request.PhieuXuatRequest;
import com.quanlysach.payload.respone.PhieuXuatRespone;
/**
 * Interface PhieuXuat
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
public interface IPhieuXuat {
	
	/**
	 * get All PX
	 * @return list Phieu Xuat
	 */
	List<PhieuXuatRespone> getAllPX();
	
	/**
	 * get Phieu Xuat By Id
	 * @param id
	 * @return
	 */
	PhieuXuatRespone getById(Long id);
	
	/**
	 * add Phieu Xuat
	 * @param phieuXuatEntity
	 */
	void addPhieuXuat(PhieuXuatEntity phieuXuatEntity);
	
	/**
	 * create Phieu Xuat
	 * @param list
	 * @return
	 */
	PhieuXuatEntity createPhieuXuat(List<PhieuXuatRequest> list);
	
	/**
	 * get Phieu Xuat Last
	 * @return
	 */
	PhieuXuatRespone getPhieuXuatLast();
}
