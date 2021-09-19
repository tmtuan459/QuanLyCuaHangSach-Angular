package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.PhieuNhapEntity;
import com.quanlysach.payload.request.PhieuNhapRequest;
/**
 * Interface Phieu Nhap Chi Tiet
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
public interface IPhieuNhapChiTiet {
	/**
	 * add Phieu Nhap ChiTiet
	 * @param phieuNhapRequest
	 * @param phieuNhapEntity
	 */
	void addPhieuNhapChiTiet(List<PhieuNhapRequest> phieuNhapRequest,PhieuNhapEntity phieuNhapEntity);
	
}
