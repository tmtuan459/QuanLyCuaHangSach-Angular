package com.quanlysach.convert;

import org.springframework.stereotype.Component;

import com.quanlysach.entities.TheLoaiEntity;
import com.quanlysach.payload.request.TheLoaiRequest;

/**
* TheLoaiConvert
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
public class TheLoaiConvert {
	/**
	 * covert the loai request to the loai entity
	 * @param theLoaiRequest
	 * @return typeEntity
	 */
	public TheLoaiEntity toEntity(TheLoaiRequest theLoaiRequest) {
		TheLoaiEntity theLoaiEntity = new TheLoaiEntity();
		
		theLoaiEntity.setTenTheLoai(theLoaiRequest.getTenTheLoai());
		theLoaiEntity.setGhiChu(theLoaiRequest.getGhiChu());
		
		return theLoaiEntity;
	}
}
