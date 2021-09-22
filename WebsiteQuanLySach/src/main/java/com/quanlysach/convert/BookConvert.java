package com.quanlysach.convert;

import org.springframework.stereotype.Component;

import com.quanlysach.entities.BookEntity;
import com.quanlysach.entities.AuthorEntity;
import com.quanlysach.entities.TypeEntity;
import com.quanlysach.payload.request.BookRequest;
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
public class BookConvert {
	
	/**
	 * convert sach request to sach entity
	 * @param sachRequest
	 * @param theLoaiEntity
	 * @param tacGiaEntity
	 * @return bookentity
	 */
	public BookEntity toEntity (BookRequest sachRequest,TypeEntity theLoaiEntity, AuthorEntity tacGiaEntity ) {
		BookEntity sachEntity = new BookEntity();
		
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
