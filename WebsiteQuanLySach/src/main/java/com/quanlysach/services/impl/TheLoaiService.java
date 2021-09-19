package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.convert.TheLoaiConvert;
import com.quanlysach.entities.TheLoaiEntity;
import com.quanlysach.payload.request.TheLoaiRequest;
import com.quanlysach.payload.request.TheLoaiUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.TheLoaiRespone;
import com.quanlysach.repositories.TheLoaiRepository;
import com.quanlysach.services.ITheLoai;
/**
 * Service The Loai
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
public class TheLoaiService implements ITheLoai {

	@Autowired
	private TheLoaiConvert theLoaiConvert;

	@Autowired
	private TheLoaiRepository theLoaiRepository;

	@Override
	public TheLoaiEntity createTheLoai(TheLoaiRequest theLoaiRequest) {	
		try {
			return theLoaiRepository.save(theLoaiConvert.toEntity(theLoaiRequest));	
		} catch (Exception e) {
			return null;
		}
			
	}

	@Override
	public List<TheLoaiRespone> findAllByDeleteFlagFalse() {
		try {

			List<TheLoaiEntity> listTypes = theLoaiRepository.findAllByDeleteFlagFalse();

			List<TheLoaiRespone> listTypesRespone = new ArrayList<>();

			listTypes.forEach(type -> {
				listTypesRespone.add(new TheLoaiRespone(type.getId(), type.getTenTheLoai(),type.getGhiChu(), type.isDeleteFlag()));
			});
			return listTypesRespone;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public MessageRespone editTheLoai(TheLoaiUpdateRequest theLoaiUpdateRequest) {
		try {
			TheLoaiEntity theLoaiEntity = theLoaiRepository.findOne(theLoaiUpdateRequest.getId());
			
			if (theLoaiEntity != null) {
				
//				theLoaiEntity.setTenTheLoai(theLoaiUpdateRequest.getTenTheLoai());//khoong nhan vao` vi khong mua ten thay doi> disable ca? o FE
				theLoaiEntity.setGhiChu(theLoaiUpdateRequest.getGhiChu());
				theLoaiRepository.save(theLoaiEntity);

			} else {
				return new MessageRespone("Sách hoặc thể loại hoặc tác giả không tồn tại!");
			}
			return new MessageRespone("Cập nhật sách thành công!");
		} catch (Exception e) {
			return new MessageRespone("Lỗi !");
		}
	}

	@Override
	public TheLoaiRespone findByIdType(Long Id) {
		TheLoaiEntity theLoai = theLoaiRepository.findOne(Id);
		return new TheLoaiRespone(theLoai.getId(),theLoai.getTenTheLoai(),theLoai.getGhiChu(),theLoai.isDeleteFlag());
	}

	@Override
	public MessageRespone toggleDeleteFlagById(Long id) {
		try {
			TheLoaiEntity theLoaiEntity = theLoaiRepository.findOne(id);

			MessageRespone messageRespone = new MessageRespone();

			if (!theLoaiEntity.isDeleteFlag()) {
				messageRespone.setMessage("Xóa sách thành công!");
			} 
			theLoaiEntity.setDeleteFlag(true);
			theLoaiRepository.save(theLoaiEntity);
			return messageRespone;

		} catch (Exception e) {
			return new MessageRespone("Id của sách không tồn tại!");

		}
	}
	
	
	
}
