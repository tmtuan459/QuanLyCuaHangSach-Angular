package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.PhieuXuatEntity;
import com.quanlysach.payload.request.PhieuXuatRequest;
/**
 * Interface PhieuXuatChiTiet
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
public interface IPhieuXuatChiTiet {
	
	/**
	 * add Phieu Xuat Chi Tiet
	 * @param phieuXuatRequest
	 * @param phieuXuatEntity
	 */
	void addPhieuXuatChiTiet(List<PhieuXuatRequest> phieuXuatRequest,PhieuXuatEntity phieuXuatEntity);
	
}
