package com.quanlysach.convert;

import org.springframework.stereotype.Component;

import com.quanlysach.entities.SachEntity;
import com.quanlysach.entities.TacGiaEntity;
import com.quanlysach.entities.TheLoaiEntity;
import com.quanlysach.payload.request.SachRequest;
/**
 * SachConvert
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
public class SachConvert {
	
	/**
	 * convert sach request to sach entity
	 * @param sachRequest
	 * @param theLoaiEntity
	 * @param tacGiaEntity
	 * @return bookentity
	 */
	public SachEntity toEntity (SachRequest sachRequest,TheLoaiEntity theLoaiEntity, TacGiaEntity tacGiaEntity ) {
		SachEntity sachEntity = new SachEntity();
		
		sachEntity.setTensach(sachRequest.getTensach());
		sachEntity.setNamXB(sachRequest.getNamXB());
		sachEntity.setTheLoai(theLoaiEntity);
		sachEntity.setTacGia(tacGiaEntity);
		sachEntity.setGioiThieu(sachRequest.getGioiThieu());
		sachEntity.setNhaXB(sachRequest.getNhaXB());
		sachEntity.setDonGia(sachRequest.getDonGia());
		sachEntity.setSoLuong(sachRequest.getSoLuong());
		
		return sachEntity;
	}
}
