package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.PhieuXuatEntity;
import com.quanlysach.payload.request.PhieuXuatRequest;
import com.quanlysach.payload.respone.PhieuXuatRespone;
import com.quanlysach.repositories.PhieuXuatRepository;
import com.quanlysach.services.IPhieuXuat;
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
public class PhieuXuatService implements IPhieuXuat{

	@Autowired
	private PhieuXuatRepository phieuXuatRepository;
	
	@Override
	public List<PhieuXuatRespone> getAllPX() {
		try {
			List<PhieuXuatEntity> listPX = phieuXuatRepository.findAllDesc();
			List<PhieuXuatRespone> listPXRespone = new ArrayList<>();
			listPX.forEach(px -> {
				listPXRespone.add(new PhieuXuatRespone(px.getId(), px.getNgayXuat(), px.getTongTien(), px.isDeleteFlag(), px.getTenNguoiNhan(),px.getDiaChi(),px.getSoDienThoai()));
			});
			return listPXRespone;

		} catch (Exception e) {
			return null;

		}
	}

	@Override
	public PhieuXuatRespone getById(Long id) {
		phieuXuatRepository.findByIdPX(id);		
		 return null;
	}

	@Override
	public void addPhieuXuat(PhieuXuatEntity phieuXuatEntity) {
		phieuXuatRepository.save(phieuXuatEntity);
	}

	@Override
	public PhieuXuatEntity createPhieuXuat(List<PhieuXuatRequest> list) {
		PhieuXuatEntity phieuXuatEntity = new PhieuXuatEntity();
		phieuXuatEntity.setNgayXuat(new Date());
		for(PhieuXuatRequest item:list) {
			phieuXuatEntity.setTenNguoiNhan(item.getTenNguoiNhan());
			phieuXuatEntity.setDiaChi(item.getDiaChi());
			phieuXuatEntity.setSoDienThoai(item.getSoDienThoai());
		}
		
		phieuXuatRepository.save(phieuXuatEntity);				
		PhieuXuatEntity pxLast= phieuXuatRepository.findByIdLast();				
		return pxLast;	
	}

	@Override
	public PhieuXuatRespone getPhieuXuatLast() {
		phieuXuatRepository.findByIdLast();
		return null;
	}
	
}
