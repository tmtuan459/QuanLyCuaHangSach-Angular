package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.ExportEntity;
import com.quanlysach.payload.request.ExportRequest;
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
public interface IExportDetail {
	
	/**
	 * add Phieu Xuat Chi Tiet
	 * @param phieuXuatRequest
	 * @param phieuXuatEntity
	 */
	void addExportDetail(List<ExportRequest> exportRequest,ExportEntity exportEntity);
	
}
