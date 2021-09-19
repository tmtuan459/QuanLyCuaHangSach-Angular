package com.quanlysach.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.ChiTietPhieuNhapEntity;
import com.quanlysach.entities.PhieuNhapEntity;
import com.quanlysach.entities.SachEntity;
import com.quanlysach.payload.request.PhieuNhapRequest;
import com.quanlysach.repositories.ChiTietPhieuNhapRepository;
import com.quanlysach.repositories.PhieuNhapRepository;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.services.IPhieuNhapChiTiet;
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
public class PhieuNhapChiTietService implements IPhieuNhapChiTiet{
	@Autowired
	private SachRepository sachRepository;
	
	@Autowired
	private ChiTietPhieuNhapRepository chiTietPNRepository;
	@Autowired
	private PhieuNhapRepository phieuNhapRepository;
	
	
	@Override
	public void addPhieuNhapChiTiet(List<PhieuNhapRequest> phieuNhapRequest, PhieuNhapEntity phieuNhapEntity) {
		int total = 0;
		
		for(PhieuNhapRequest item:phieuNhapRequest) {
			ChiTietPhieuNhapEntity chiTietPhieuNhap = new ChiTietPhieuNhapEntity();
			
			chiTietPhieuNhap.setSoLuong(item.getSoLuong());
			chiTietPhieuNhap.setDonGia(item.getDonGia());
			chiTietPhieuNhap.setPhieuNhap(phieuNhapEntity);
			chiTietPhieuNhap.setNgayNhapCT(new Date());
			
			SachEntity sachEntity = sachRepository.findByTenSach(item.getTensach());
			chiTietPhieuNhap.setMaSach(sachEntity);
		
			
			chiTietPNRepository.save(chiTietPhieuNhap);
			
			sachEntity.setSoLuong(sachEntity.getSoLuong()+item.getSoLuong());
			sachEntity.setDonGia(item.getDonGia());
			
			sachRepository.save(sachEntity);
			
			total=total+(item.getSoLuong()*item.getDonGia());
											
		}
		phieuNhapEntity.setTongTien(total);
		phieuNhapRepository.save(phieuNhapEntity);					
	}
		

}
