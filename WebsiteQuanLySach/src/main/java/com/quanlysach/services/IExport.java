package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.ExportEntity;
import com.quanlysach.payload.request.ExportRequest;
import com.quanlysach.payload.respone.ExportRespone;
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
public interface IExport {
	
	/**
	 * get All PX
	 * @return list Phieu Xuat
	 */
	List<ExportRespone> getAllExport();
	
	/**
	 * get Phieu Xuat By Id
	 * @param id
	 * @return
	 */
	ExportRespone getById(Long id);
	
	/**
	 * add Phieu Xuat
	 * @param phieuXuatEntity
	 */
	void addExport(ExportEntity exportEntity);
	
	/**
	 * create Phieu Xuat
	 * @param list
	 * @return
	 */
	ExportEntity createExport(List<ExportRequest> list);
	
	/**
	 * get Phieu Xuat Last
	 * @return
	 */
	ExportRespone getExportLast();
}
