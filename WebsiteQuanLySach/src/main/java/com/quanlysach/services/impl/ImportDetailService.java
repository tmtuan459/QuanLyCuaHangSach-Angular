package com.quanlysach.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.ImportDetailpEntity;
import com.quanlysach.entities.ImportEntity;
import com.quanlysach.entities.BookEntity;
import com.quanlysach.payload.request.ImportRequest;
import com.quanlysach.repositories.ImportDetailRepository;
import com.quanlysach.repositories.ImportRepository;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.services.IImportDetail;
/**
 * Service ChiTietPhieuNhap
 * 
 * Version 1.0
 * 
 * Date 19-08-2021
 * 
 * Modification Logs:
 * 
 * * DATE AUTHOR DESCRIPTION 
 * -------------------------
 * 
 * 17-09-2021 TuanTM24 Create
 */
@Service
public class ImportDetailService implements IImportDetail{
	
	
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ImportDetailRepository importDetailRepository;
	@Autowired
	private ImportRepository importRepository;
	
	/**
	 * add Phieu Nhap ChiTiet
	 * param phieuNhapRequest, phieuNhapEntity
	 */
	@Override
	
	public void addImportDetail(List<ImportRequest> importRequest, ImportEntity importEntity) {
		int total = 0;
		
		for(ImportRequest item:importRequest) {
			ImportDetailpEntity importDetail = new ImportDetailpEntity();
			
			importDetail.setSoLuong(item.getSoLuong());
			importDetail.setDonGia(item.getDonGia());
			importDetail.setPhieuNhap(importEntity);
			importDetail.setNgayNhapCT(new Date());
			
			BookEntity sachEntity = bookRepository.findByNameBook(item.getTensach());
			importDetail.setMaSach(sachEntity);
		
			
			importDetailRepository.save(importDetail);
			
			sachEntity.setSoLuong(sachEntity.getSoLuong()+item.getSoLuong());
			sachEntity.setDonGia(item.getDonGia());
			
			bookRepository.save(sachEntity);
			
			total=total+(item.getSoLuong()*item.getDonGia());
											
		}
		importEntity.setTongTien(total);
		importRepository.save(importEntity);					
	}
		

}
