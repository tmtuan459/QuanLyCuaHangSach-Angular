package com.quanlysach.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.ChiTietPhieuXuatEntity;
import com.quanlysach.entities.PhieuXuatEntity;
import com.quanlysach.entities.SachEntity;
import com.quanlysach.payload.request.PhieuXuatRequest;
import com.quanlysach.repositories.ChiTietPhieuXuatRepository;
import com.quanlysach.repositories.PhieuXuatRepository;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.services.IPhieuXuatChiTiet;
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
public class PhieuXuatChiTietService implements IPhieuXuatChiTiet{
	@Autowired
	private SachRepository sachRepository;
	
	@Autowired
	private ChiTietPhieuXuatRepository chiTietPXRepository;
	@Autowired
	private PhieuXuatRepository phieuXuatRepository;
	
	
	@Override
	public void addPhieuXuatChiTiet(List<PhieuXuatRequest> phieuXuatRequest, PhieuXuatEntity phieuXuatEntity) {
		int total = 0;
		
		for(PhieuXuatRequest item:phieuXuatRequest) {
			SachEntity sachEntity = sachRepository.findByTenSach(item.getTensach());

			ChiTietPhieuXuatEntity chiTietPhieuXuat = new ChiTietPhieuXuatEntity();
			
			chiTietPhieuXuat.setSoLuong(item.getSoLuong());
			chiTietPhieuXuat.setDonGia(item.getDonGia());
			chiTietPhieuXuat.setPhieuXuat(phieuXuatEntity);
			chiTietPhieuXuat.setNgayXuatCT(new Date());;
		
			chiTietPhieuXuat.setMaSachId(sachEntity);
		
			
			chiTietPXRepository.save(chiTietPhieuXuat);
			
			sachEntity.setSoLuong(sachEntity.getSoLuong()-item.getSoLuong());
			
			sachRepository.save(sachEntity);
			
			total=total+(item.getSoLuong()*item.getDonGia());
											
		}
		phieuXuatEntity.setTongTien(total);
		phieuXuatRepository.save(phieuXuatEntity);	
	}
		
}
