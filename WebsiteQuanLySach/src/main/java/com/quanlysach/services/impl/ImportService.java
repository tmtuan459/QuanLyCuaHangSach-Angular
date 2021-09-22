package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.ImportEntity;
import com.quanlysach.payload.respone.ImportRespone;
import com.quanlysach.repositories.ImportRepository;
import com.quanlysach.services.IImport;
/**
 * Service PhieuNhap
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
@Service
public class ImportService implements IImport {
	@Autowired
	private ImportRepository ImportRepository;
	
	/**
	 * create Phieu Nhap
	 */
	@Override
	public ImportEntity createImport() {

				ImportEntity importEntity = new ImportEntity();
				importEntity.setNgayNhap(new Date());
				ImportRepository.save(importEntity);				
				ImportEntity pnLast= ImportRepository.findByIdLast();				
				return pnLast;							
	}

	/**
	 * get All Phieu Nhap
	 */
	@Override
	public List<ImportRespone> getAllImport() {
		try {
			List<ImportEntity> listImport = ImportRepository.findAllDesc();
			List<ImportRespone> listImportRespone = new ArrayList<>();
			listImport.forEach(pn -> {
				listImportRespone
						.add(new ImportRespone(pn.getId(), pn.getNgayNhap(), pn.getTongTien(), pn.isDeleteFlag()));
			});
			return listImportRespone;

		} catch (Exception e) {
			return null;

		}
	}
	/**
	 * get Phieu Nhap By Id
	 */
	@Override
	public ImportRespone getById(Long id) {
		ImportRepository.findByIdPN(id);
	
		 return null;
	}
	
	/**
	 * add Phieu Nhap
	 */
	@Override
	public void addImport(ImportEntity importEntity) {
		ImportRepository.save(importEntity);
	}

	/**
	 * get Phieu Nhap Last
	 */
	@Override
	public ImportRespone getImportLast() {
		ImportRepository.findByIdLast();
		return null;
	}

}
