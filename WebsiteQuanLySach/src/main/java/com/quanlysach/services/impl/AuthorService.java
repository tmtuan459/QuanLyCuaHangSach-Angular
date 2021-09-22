package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.convert.AuthorConvert;
import com.quanlysach.entities.AuthorEntity;
import com.quanlysach.payload.request.AuthorRequest;
import com.quanlysach.payload.request.AuthorUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.AuthorRespone;
import com.quanlysach.repositories.AuthorRepository;
import com.quanlysach.services.IAuthor;
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
public class AuthorService implements IAuthor{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorConvert authorConvert;
	/**
	 * create Author
	 * param authorRequest
	 */
	@Override
	public AuthorEntity createAuthor(AuthorRequest authorRequest) {
		try {
			return authorRepository.save(authorConvert.toEntity(authorRequest));
		} catch (Exception e) {
			return null;
		}
		
	}
	
	/**
	 * find All By Delete Flag False
	 */
	@Override
	public List<AuthorRespone> findAllByDeleteFlagFalse() {
		try {

			List<AuthorEntity> listAuthors = authorRepository.findAllByDeleteFlagFalse();

			List<AuthorRespone> listAuthorsRespone = new ArrayList<>();

			listAuthors.forEach(author -> {
				listAuthorsRespone.add(new AuthorRespone(author.getId(), author.getTenTacGia(), author.getGhiChu(), author.isDeleteFlag()));
			});
			return listAuthorsRespone;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * edit Author
	 * param tacGiaUpdateRequest
	 */
	@Override
	@Transactional //rollback data when error
	public MessageRespone editAuthor(AuthorUpdateRequest authorUpdateRequest) {
		try {
			AuthorEntity authoEntity = authorRepository.findOne(authorUpdateRequest.getId());
			
			if (authoEntity != null) {//khong nhan gia tri ten tac gia, vi khong muon no thay doi tahnh trung
				
				authoEntity.setGhiChu(authorUpdateRequest.getGhiChu());
				
				authorRepository.save(authoEntity);

			} else {
				return new MessageRespone("thể loại không tồn tại!");
			}
			return new MessageRespone("Cập nhật thể loại  thành công!");
		} catch (Exception e) {
			return new MessageRespone("Lỗi !");
		}
	}

	/**
	 * toggle Delete Flag By Id
	 * param id
	 */
	@Override
	@Transactional //rollback data when error
	public MessageRespone toggleDeleteFlagById(Long id) {
		try {
			AuthorEntity authorEntity = authorRepository.findOne(id);

			MessageRespone messageRespone = new MessageRespone();

			if (!authorEntity.isDeleteFlag()) {
				messageRespone.setMessage("Xóa sách thành công!");
			} 
			authorEntity.setDeleteFlag(true);
			authorRepository.save(authorEntity);
			return messageRespone;

		} catch (Exception e) {
			return new MessageRespone("Id của sách không tồn tại!");

		}
	}

	/**
	 * find By Id Author
	 * param id
	 */
	@Override
	public AuthorRespone findByIdAuthor(Long Id) {
		AuthorEntity author = authorRepository.findOne(Id);
		return new AuthorRespone(author.getId(),author.getTenTacGia(),author.getGhiChu(),author.isDeleteFlag());
		
		
	}
	 
		
	
	
}
