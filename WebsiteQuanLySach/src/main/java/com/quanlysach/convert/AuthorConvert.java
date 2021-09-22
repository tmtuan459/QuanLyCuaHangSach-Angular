package com.quanlysach.convert;

import org.springframework.stereotype.Component;

import com.quanlysach.entities.AuthorEntity;
import com.quanlysach.payload.request.AuthorRequest;

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
public class AuthorConvert {
	/**
	 * covert tac gia request to tac gia entity
	 * @param tacGiaRequest
	 * @return authorEntity
	 */
	public AuthorEntity toEntity(AuthorRequest tacGiaRequest) {		
		AuthorEntity tacGiaEntity = new AuthorEntity();
		
		tacGiaEntity.setTenTacGia(tacGiaRequest.getTenTacGia());
		tacGiaEntity.setGhiChu(tacGiaRequest.getGhiChu());
		
		return tacGiaEntity;
	}
}
