package com.quanlysach.services;

import java.util.List;

import com.quanlysach.entities.ImportEntity;
import com.quanlysach.payload.respone.ImportRespone;
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
public interface IImport {
	/**
	 * get All phieu nhap
	 * @return
	 */
	List<ImportRespone> getAllImport();
	
	/**
	 * get Phieu nhap By Id
	 * @param id
	 * @return
	 */
	ImportRespone getById(Long id);
	
	/**
	 * add Phieu Nhap
	 * @param phieuNhapEntity
	 */
	void addImport(ImportEntity importEntity);
	
	/**
	 * create Phieu Nhap
	 * @return
	 */
	ImportEntity createImport();
	
	/**
	 * get Phieu Nhap Last
	 * @return
	 */
	ImportRespone getImportLast();
}
