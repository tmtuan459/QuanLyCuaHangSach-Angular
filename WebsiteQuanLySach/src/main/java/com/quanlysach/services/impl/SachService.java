package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.convert.SachConvert;
import com.quanlysach.entities.SachEntity;
import com.quanlysach.entities.TacGiaEntity;
import com.quanlysach.entities.TheLoaiEntity;
import com.quanlysach.payload.request.SachRequest;
import com.quanlysach.payload.request.SachUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.SachRespone;
import com.quanlysach.repositories.SachRepository;
import com.quanlysach.repositories.TacGiaRepository;
import com.quanlysach.repositories.TheLoaiRepository;
import com.quanlysach.services.ISach;
/**
 * Service Sach
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
public class SachService implements ISach {

	@Autowired
	private SachRepository sachRepository;
	@Autowired
	private SachConvert sachConvert;
	@Autowired
	private TheLoaiRepository theLoaiRepository;
	@Autowired
	private TacGiaRepository tacGiaRepository;
	
	@Override
	public SachRespone createSach(SachRequest sachRequest) {
		try {
			TheLoaiEntity theLoai = theLoaiRepository.findByTenTheLoai(sachRequest.getTheLoaiId());
			TacGiaEntity tacGia = tacGiaRepository.findByTenTacGia(sachRequest.getTacGiaId());

			if (theLoai != null && tacGia != null) {
				SachEntity sach = sachRepository.save(sachConvert.toEntity(sachRequest, theLoai, tacGia));
				return new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
						sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia());//phair dung thu tu nhu ben Sach Respone neu khong tra ve postman se~ lech. gia tri,

			} else {
				return null;

			}

		} catch (Exception e) {
			return null;
		}

	}

	

	@Override
	public SachRespone findByIdBook(Long Id) {
		SachEntity sach = sachRepository.findOne(Id);
		return new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
				sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia());
	}
	
//	@Override
//	public SachRespone findByNameBook(String name) {
//		SachEntity sach = sachRepository.findIdByTenSach(name);
//		return new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
//				sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia());
//	}


	@Override
	public MessageRespone editSach(SachUpdateRequest sachUpdateRequest) {
		try {
			SachEntity sachEntity = sachRepository.findOne(sachUpdateRequest.getId());
			TheLoaiEntity theLoai = theLoaiRepository.findByTenTheLoai(sachUpdateRequest.getTheLoaiId());
			TacGiaEntity tacGia = tacGiaRepository.findByTenTacGia(sachUpdateRequest.getTacGiaId());
			if (sachEntity != null && theLoai != null && tacGia != null) {
//				sachEntity.setTensach(sachUpdateRequest.getTensach()); ko nhan vao` vi ko muon trung ten
				sachEntity.setNamXB(sachUpdateRequest.getNamXB());
				sachEntity.setNhaXB(sachUpdateRequest.getNhaXB());
				sachEntity.setTacGia(tacGia);
				sachEntity.setTheLoai(theLoai);
				sachEntity.setGioiThieu(sachUpdateRequest.getGioiThieu());
				sachRepository.save(sachEntity);

			} else {
				return new MessageRespone("Sách hoặc thể loại hoặc tác giả không tồn tại!");
			}
			return new MessageRespone("Cập nhật sách thành công!");
		} catch (Exception e) {
			return new MessageRespone("Lỗi !");
		}
	}

	@Override
	public List<SachEntity> findAllByDeleteFlagFalse() {
		try {

			List<SachEntity> listBooks = sachRepository.listAllBook();

//			List<SachEntity> listBooksRespone = new ArrayList<>();
//
//			listBooks.forEach(sach -> {
//				listBooksRespone.add(new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
//						sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia()));
//			});
			return listBooks;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SachRespone> findAllByDeleteFlagTrue() {
		try {

			List<SachEntity> listBooks = sachRepository.findAllByDeleteFlagTrue();

			List<SachRespone> listBooksRespone = new ArrayList<>();

			listBooks.forEach(sach -> {
				listBooksRespone.add(new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
						sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia()));
			});
			return listBooksRespone;
		} catch (Exception e) {
			return null;
		}
	}

	
	@Override
	public List<SachRespone> listBookInsufficient() {
		try {

			List<SachEntity> listBooks = sachRepository.listBookInsufficient();

			List<SachRespone> listBooksRespone = new ArrayList<>();

			listBooks.forEach(sach -> {
				listBooksRespone.add(new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
						sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia()));
			});
			return listBooksRespone;
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	public List<SachRespone> listBookRedundant() {
		try {

			List<SachEntity> listBooks = sachRepository.listBookRedundant();

			List<SachRespone> listBooksRespone = new ArrayList<>();

			listBooks.forEach(sach -> {
				listBooksRespone.add(new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
						sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia()));
			});
			return listBooksRespone;
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	public MessageRespone toggleDeleteFlagById(Long id) {
		try {
			SachEntity sachEntity = sachRepository.findOne(id);

			MessageRespone messageRespone = new MessageRespone();

			if (!sachEntity.isDeleteFlag()) {
				messageRespone.setMessage("Xóa sách thành công!");
			} 
			sachEntity.setDeleteFlag(true);
			sachRepository.save(sachEntity);
			return messageRespone;

		} catch (Exception e) {
			return new MessageRespone("Id của sách không tồn tại!");

		}

	}




	

}
