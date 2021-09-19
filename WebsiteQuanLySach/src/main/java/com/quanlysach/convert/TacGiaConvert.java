package com.quanlysach.convert;

import org.springframework.stereotype.Component;

import com.quanlysach.entities.TacGiaEntity;
import com.quanlysach.payload.request.TacGiaRequest;

/**
 * TacGiaConvert
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
@Component
public class TacGiaConvert {
	/**
	 * covert tac gia request to tac gia entity
	 * @param tacGiaRequest
	 * @return authorEntity
	 */
	public TacGiaEntity toEntity(TacGiaRequest tacGiaRequest) {		
		TacGiaEntity tacGiaEntity = new TacGiaEntity();
		
		tacGiaEntity.setTenTacGia(tacGiaRequest.getTenTacGia());
		tacGiaEntity.setGhiChu(tacGiaRequest.getGhiChu());
		
		return tacGiaEntity;
	}
}
