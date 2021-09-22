package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.ImportEntity;
import com.quanlysach.payload.request.ImportRequest;
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
public interface IImportDetail {
	/**
	 * add Phieu Nhap ChiTiet
	 * @param phieuNhapRequest
	 * @param phieuNhapEntity
	 */
	void addImportDetail(List<ImportRequest> importRequest,ImportEntity importEntity);
	
}
