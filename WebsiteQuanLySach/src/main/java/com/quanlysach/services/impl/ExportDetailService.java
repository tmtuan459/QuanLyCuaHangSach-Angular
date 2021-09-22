package com.quanlysach.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.ExportDetailEntity;
import com.quanlysach.entities.ExportEntity;
import com.quanlysach.entities.BookEntity;
import com.quanlysach.payload.request.ExportRequest;
import com.quanlysach.repositories.ExportDetailRepository;
import com.quanlysach.repositories.ExportRepository;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.services.IExportDetail;
/**
 * Service Chi Tiet Phieu Xuat
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
public class ExportDetailService implements IExportDetail{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ExportDetailRepository exportDetailRepository;
	@Autowired
	private ExportRepository exportRepository;
	
	/**
	 * add Phieu Xuat Chi Tiet
	 * param phieuXuatRequest, phieuXuatEntity
	 */
	@Override
	public void addExportDetail(List<ExportRequest> exportRequest, ExportEntity exportEntity) {
		int total = 0;
		
		for(ExportRequest item:exportRequest) {
			BookEntity sachEntity = bookRepository.findByNameBook(item.getTensach());

			ExportDetailEntity chiTietPhieuXuat = new ExportDetailEntity();
			
			chiTietPhieuXuat.setSoLuong(item.getSoLuong());
			chiTietPhieuXuat.setDonGia(item.getDonGia());
			chiTietPhieuXuat.setPhieuXuat(exportEntity);
			chiTietPhieuXuat.setNgayXuatCT(new Date());;
		
			chiTietPhieuXuat.setMaSachId(sachEntity);
		
			
			exportDetailRepository.save(chiTietPhieuXuat);
			
			sachEntity.setSoLuong(sachEntity.getSoLuong()-item.getSoLuong());
			
			bookRepository.save(sachEntity);
			
			total=total+(item.getSoLuong()*item.getDonGia());
											
		}
		exportEntity.setTongTien(total);
		exportRepository.save(exportEntity);	
	}
		
}
