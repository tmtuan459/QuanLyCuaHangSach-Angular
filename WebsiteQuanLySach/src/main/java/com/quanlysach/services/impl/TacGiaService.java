package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.convert.TacGiaConvert;
import com.quanlysach.entities.TacGiaEntity;
import com.quanlysach.payload.request.TacGiaRequest;
import com.quanlysach.payload.request.TacGiaUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.TacGiaRespone;
import com.quanlysach.repositories.TacGiaRepository;
import com.quanlysach.services.ITacGia;
/**
 * Service Tac Gia
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
public class TacGiaService implements ITacGia{
	
	@Autowired
	private TacGiaRepository tacGiaRepository;
	
	@Autowired
	private TacGiaConvert tacGiaConvert;

	@Override
	public TacGiaEntity createAuthor(TacGiaRequest tacGiaRequest) {
		try {
			return tacGiaRepository.save(tacGiaConvert.toEntity(tacGiaRequest));
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<TacGiaRespone> findAllByDeleteFlagFalse() {
		try {

			List<TacGiaEntity> listAuthors = tacGiaRepository.findAllByDeleteFlagFalse();

			List<TacGiaRespone> listAuthorsRespone = new ArrayList<>();

			listAuthors.forEach(author -> {
				listAuthorsRespone.add(new TacGiaRespone(author.getId(), author.getTenTacGia(), author.getGhiChu(), author.isDeleteFlag()));
			});
			return listAuthorsRespone;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public MessageRespone editAuthor(TacGiaUpdateRequest tacGiaUpdateRequest) {
		try {
			TacGiaEntity tacGiaEntity = tacGiaRepository.findOne(tacGiaUpdateRequest.getId());
			
			if (tacGiaEntity != null) {//khong nhan gia tri ten tac gia, vi khong muon no thay doi tahnh trung
				
				tacGiaEntity.setGhiChu(tacGiaUpdateRequest.getGhiChu());
				
				tacGiaRepository.save(tacGiaEntity);

			} else {
				return new MessageRespone("thể loại không tồn tại!");
			}
			return new MessageRespone("Cập nhật thể loại  thành công!");
		} catch (Exception e) {
			return new MessageRespone("Lỗi !");
		}
	}

	@Override
	public MessageRespone toggleDeleteFlagById(Long id) {
		try {
			TacGiaEntity tacGiaEntity = tacGiaRepository.findOne(id);

			MessageRespone messageRespone = new MessageRespone();

			if (!tacGiaEntity.isDeleteFlag()) {
				messageRespone.setMessage("Xóa sách thành công!");
			} 
			tacGiaEntity.setDeleteFlag(true);
			tacGiaRepository.save(tacGiaEntity);
			return messageRespone;

		} catch (Exception e) {
			return new MessageRespone("Id của sách không tồn tại!");

		}
	}

	@Override
	public TacGiaRespone findByIdAuthor(Long Id) {
		TacGiaEntity tacGia = tacGiaRepository.findOne(Id);
		return new TacGiaRespone(tacGia.getId(),tacGia.getTenTacGia(),tacGia.getGhiChu(),tacGia.isDeleteFlag());
		
		
	}
	 
		
	
	
}
