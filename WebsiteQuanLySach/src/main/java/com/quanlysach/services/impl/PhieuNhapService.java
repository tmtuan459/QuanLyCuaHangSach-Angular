package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.entities.PhieuNhapEntity;
import com.quanlysach.payload.respone.PhieuNhapRespone;
import com.quanlysach.repositories.PhieuNhapRepository;
import com.quanlysach.services.IPhieuNhap;
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
public class PhieuNhapService implements IPhieuNhap {
	@Autowired
	private PhieuNhapRepository phieuNhapRepository;
	

	@Override
	public PhieuNhapEntity createPhieuNhap() {

				PhieuNhapEntity phieuNhapEntity = new PhieuNhapEntity();
				phieuNhapEntity.setNgayNhap(new Date());
				phieuNhapRepository.save(phieuNhapEntity);				
				PhieuNhapEntity pnLast= phieuNhapRepository.findByIdLast();				
				return pnLast;							
	}


	@Override
	public List<PhieuNhapRespone> getAllPN() {
		try {
			List<PhieuNhapEntity> listPN = phieuNhapRepository.findAllDesc();
			List<PhieuNhapRespone> listPNRespone = new ArrayList<>();
			listPN.forEach(pn -> {
				listPNRespone
						.add(new PhieuNhapRespone(pn.getId(), pn.getNgayNhap(), pn.getTongTien(), pn.isDeleteFlag()));
			});
			return listPNRespone;

		} catch (Exception e) {
			return null;

		}
	}

	@Override
	public PhieuNhapRespone getById(Long id) {
		 phieuNhapRepository.findByIdPN(id);
	
		 return null;
	}

	@Override
	public void addPhieuNhap(PhieuNhapEntity phieuNhapEntity) {
		phieuNhapRepository.save(phieuNhapEntity);
	}

	@Override
	public PhieuNhapRespone getPhieuNhapLast() {
		phieuNhapRepository.findByIdLast();
		return null;
	}

}
