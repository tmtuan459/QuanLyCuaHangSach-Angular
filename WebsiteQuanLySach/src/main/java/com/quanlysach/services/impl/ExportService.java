package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.ExportEntity;
import com.quanlysach.payload.request.ExportRequest;
import com.quanlysach.payload.respone.ExportRespone;
import com.quanlysach.repositories.ExportRepository;
import com.quanlysach.services.IExport;
/**
 * Service Phieu Xuat
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
public class ExportService implements IExport{

	@Autowired
	private ExportRepository exportRepository;
	/**
	 * get All Phieu Xuat
	 */
	@Override
	public List<ExportRespone> getAllExport() {
		try {
			List<ExportEntity> listPX = exportRepository.findAllDesc();
			List<ExportRespone> listPXRespone = new ArrayList<>();
			listPX.forEach(px -> {
				listPXRespone.add(new ExportRespone(px.getId(), px.getNgayXuat(), px.getTongTien(), px.isDeleteFlag(), px.getTenNguoiNhan(),px.getDiaChi(),px.getSoDienThoai()));
			});
			return listPXRespone;

		} catch (Exception e) {
			return null;

		}
	}
	/**
	 * get Phieu Xuat By Id
	 * param id
	 */
	@Override
	public ExportRespone getById(Long id) {
		exportRepository.findByIdExport(id);		
		 return null;
	}
	
	/**
	 * add Phieu Xuat
	 * param phieuXuatEntity
	 */
	@Override
	public void addExport(ExportEntity exportEntity) {
		exportRepository.save(exportEntity);
	}

	/**
	 * create PhieuXuat
	 * param list
	 */
	@Override
	public ExportEntity createExport(List<ExportRequest> list) {
		ExportEntity exportEntity = new ExportEntity();
		exportEntity.setNgayXuat(new Date());
		for(ExportRequest item:list) {
			exportEntity.setTenNguoiNhan(item.getTenNguoiNhan());
			exportEntity.setDiaChi(item.getDiaChi());
			exportEntity.setSoDienThoai(item.getSoDienThoai());
		}
		
		exportRepository.save(exportEntity);				
		ExportEntity pxLast= exportRepository.findByIdLast();				
		return pxLast;	
	}

	@Override
	public ExportRespone getExportLast() {
		exportRepository.findByIdLast();
		return null;
	}
	
}
