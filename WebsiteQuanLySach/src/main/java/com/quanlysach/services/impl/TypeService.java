package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.convert.TypeConvert;
import com.quanlysach.entities.TypeEntity;
import com.quanlysach.payload.request.TypeRequest;
import com.quanlysach.payload.request.TypeUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.TypeRespone;
import com.quanlysach.repositories.TypeRepository;
import com.quanlysach.services.IType;
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
public class TypeService implements IType {

	@Autowired
	private TypeConvert typeConvert;

	@Autowired
	private TypeRepository typeRepository;

	@Override
	public TypeEntity createType(TypeRequest typeRequest) {	
		try {
			return typeRepository.save(typeConvert.toEntity(typeRequest));	
		} catch (Exception e) {
			return null;
		}
			
	}
	/**
	 * find All By Delete Flag False
	 */
	@Override
	public List<TypeRespone> findAllByDeleteFlagFalse() {
		try {

			List<TypeEntity> listTypes = typeRepository.findAllByDeleteFlagFalse();

			List<TypeRespone> listTypesRespone = new ArrayList<>();

			listTypes.forEach(type -> {
				listTypesRespone.add(new TypeRespone(type.getId(), type.getTenTheLoai(),type.getGhiChu(), type.isDeleteFlag()));
			});
			return listTypesRespone;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * edit TheLoai
	 * param theLoaiUpdateRequest
	 */
	@Override
	@Transactional //rollback data when error
	public MessageRespone editType(TypeUpdateRequest typeUpdateRequest) {
		try {
			TypeEntity typeEntity =  typeRepository.findOne(typeUpdateRequest.getId());
			
			if (typeEntity != null) {
				
//				theLoaiEntity.setTenTheLoai(theLoaiUpdateRequest.getTenTheLoai());//khoong nhan vao` vi khong mua ten thay doi> disable ca? o FE
				typeEntity.setGhiChu(typeUpdateRequest.getGhiChu());
				 typeRepository.save(typeEntity);

			} else {
				return new MessageRespone("Sách hoặc thể loại hoặc tác giả không tồn tại!");
			}
			return new MessageRespone("Cập nhật sách thành công!");
		} catch (Exception e) {
			return new MessageRespone("Lỗi !");
		}
	}

	/**
	 * find By Id Type
	 * param id
	 */
	@Override
	public TypeRespone findByIdType(Long Id) {
		TypeEntity type =  typeRepository.findOne(Id);
		return new TypeRespone(type.getId(),type.getTenTheLoai(),type.getGhiChu(),type.isDeleteFlag());
	}
	
	/**
	 * toggle Delete Flag By Id
	 * param id
	 */
	@Override
	@Transactional //rollback data when error
	public MessageRespone toggleDeleteFlagById(Long id) {
		try {
			TypeEntity typeEntity =  typeRepository.findOne(id);

			MessageRespone messageRespone = new MessageRespone();

			if (!typeEntity.isDeleteFlag()) {
				messageRespone.setMessage("Xóa sách thành công!");
			} 
			typeEntity.setDeleteFlag(true);
			 typeRepository.save(typeEntity);
			return messageRespone;

		} catch (Exception e) {
			return new MessageRespone("Id của sách không tồn tại!");

		}
	}
	
	
	
}
