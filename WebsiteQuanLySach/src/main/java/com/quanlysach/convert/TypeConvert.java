package com.quanlysach.convert;

import org.springframework.stereotype.Component;

import com.quanlysach.entities.TypeEntity;
import com.quanlysach.payload.request.TypeRequest;

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
public class TypeConvert {
	/**
	 * covert the loai request to the loai entity
	 * @param theLoaiRequest
	 * @return typeEntity
	 */
	public TypeEntity toEntity(TypeRequest theLoaiRequest) {
		TypeEntity theLoaiEntity = new TypeEntity();
		
		theLoaiEntity.setTenTheLoai(theLoaiRequest.getTenTheLoai());
		theLoaiEntity.setGhiChu(theLoaiRequest.getGhiChu());
		
		return theLoaiEntity;
	}
}
