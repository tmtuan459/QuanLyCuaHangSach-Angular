package com.quanlysach.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysach.convert.BookConvert;
import com.quanlysach.entities.BookEntity;
import com.quanlysach.entities.AuthorEntity;
import com.quanlysach.entities.TypeEntity;
import com.quanlysach.payload.request.BookRequest;
import com.quanlysach.payload.request.BookUpdateRequest;
import com.quanlysach.payload.respone.MessageRespone;
import com.quanlysach.payload.respone.BookRespone;
import com.quanlysach.repositories.BookRepository;
import com.quanlysach.repositories.AuthorRepository;
import com.quanlysach.repositories.TypeRepository;
import com.quanlysach.services.IBook;
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
public class BookService implements IBook {
	



	private BookRepository bookRepository;

	private BookConvert bookConvert;

	private TypeRepository typeRepository;

	private AuthorRepository authorRepository;
	
	@Autowired
	BookService(BookRepository bookRepository,BookConvert bookConvert,TypeRepository typeRepository,AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.bookConvert = bookConvert;
		this.typeRepository = typeRepository;
		this.authorRepository = authorRepository;
	}
	
	/**
	 * create Sach
	 * param sachRequest
	 */
	@Override
	public BookRespone createBook(BookRequest bookRequest) {
		
		
		try {
			TypeEntity type = typeRepository.findByNameType(bookRequest.getTheLoaiId());
			AuthorEntity author = authorRepository.findByNameAuthor(bookRequest.getTacGiaId());

			if (type != null && author != null) {
				BookEntity book = bookRepository.save(bookConvert.toEntity(bookRequest, type, author));
				return new BookRespone(book.getId(), book.getTensach(), book.getNamXB(), book.isDeleteFlag(), book.getGioiThieu(),book.getNhaXB(),
						book.getTacGia().getId(), book.getTheLoai().getId(),book.getSoLuong(),book.getDonGia());//phair dung thu tu nhu ben Sach Respone neu khong tra ve postman se~ lech. gia tri,

			} else {
				return null;

			}

		} catch (Exception e) {
			return null;
		}

	}

	
	/**
	 * find By Id Book
	 * param id
	 */
	@Override
	public BookRespone findByIdBook(Long Id) {
		BookEntity book = bookRepository.findOne(Id);
		return new BookRespone(book.getId(), book.getTensach(), book.getNamXB(), book.isDeleteFlag(), book.getGioiThieu(),book.getNhaXB(),
				book.getTacGia().getId(), book.getTheLoai().getId(),book.getSoLuong(),book.getDonGia());
	}
	
//	@Override
//	public SachRespone findByNameBook(String name) {
//		SachEntity sach = sachRepository.findIdByTenSach(name);
//		return new SachRespone(sach.getId(), sach.getTensach(), sach.getNamXB(), sach.isDeleteFlag(), sach.getGioiThieu(),sach.getNhaXB(),
//				sach.getTacGia().getId(), sach.getTheLoai().getId(),sach.getSoLuong(),sach.getDonGia());
//	}

	/**
	 * edit Sach
	 * param sachUpdateRequest
	 */
	@Override
	@Transactional //rollback data when error
	public MessageRespone editBook(BookUpdateRequest bookUpdateRequest) {
		try {
			BookEntity bookEntity = bookRepository.findOne(bookUpdateRequest.getId());
			TypeEntity type = typeRepository.findByNameType(bookUpdateRequest.getTheLoaiId());
			AuthorEntity author = authorRepository.findByNameAuthor(bookUpdateRequest.getTacGiaId());
			if (bookEntity != null && type != null && author != null) {
//				sachEntity.setTensach(sachUpdateRequest.getTensach()); ko nhan vao` vi ko muon trung ten
				bookEntity.setNamXB(bookUpdateRequest.getNamXB());
				bookEntity.setNhaXB(bookUpdateRequest.getNhaXB());
				bookEntity.setTacGia(author);
				bookEntity.setTheLoai(type);
				bookEntity.setGioiThieu(bookUpdateRequest.getGioiThieu());
				bookRepository.save(bookEntity);

			} else {
				return new MessageRespone("Sách hoặc thể loại hoặc tác giả không tồn tại!");
			}
			return new MessageRespone("Cập nhật sách thành công!");
		} catch (Exception e) {
			return new MessageRespone("Lỗi !");
		}
	}

	/**
	 * find All By Delete Flag False
	 */
	@Override
	public List<BookEntity> findAllByDeleteFlagFalse() {
		try {

			List<BookEntity> listBooks = bookRepository.listAllBook();

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

	/**
	 * find All By Delete Flag True
	 */
	@Override
	public List<BookRespone> findAllByDeleteFlagTrue() {
		try {

			List<BookEntity> listBooks = bookRepository.findAllByDeleteFlagTrue();

			List<BookRespone> listBooksRespone = new ArrayList<>();

			listBooks.forEach(book -> {
				listBooksRespone.add(new BookRespone(book.getId(), book.getTensach(), book.getNamXB(), book.isDeleteFlag(), book.getGioiThieu(),book.getNhaXB(),
						book.getTacGia().getId(), book.getTheLoai().getId(),book.getSoLuong(),book.getDonGia()));
			});
			return listBooksRespone;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * list Book Insufficient
	 */
	@Override
	public List<BookRespone> listBookInsufficient() {
		try {

			List<BookEntity> listBooks = bookRepository.listBookInsufficient();

			List<BookRespone> listBooksRespone = new ArrayList<>();

			listBooks.forEach(book -> {
				listBooksRespone.add(new BookRespone(book.getId(), book.getTensach(), book.getNamXB(), book.isDeleteFlag(), book.getGioiThieu(),book.getNhaXB(),
						book.getTacGia().getId(), book.getTheLoai().getId(),book.getSoLuong(),book.getDonGia()));
			});
			return listBooksRespone;
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * list Book Redundant
	 */
	@Override
	public List<BookRespone> listBookRedundant() {
		try {

			List<BookEntity> listBooks = bookRepository.listBookRedundant();

			List<BookRespone> listBooksRespone = new ArrayList<>();

			listBooks.forEach(book -> {
				listBooksRespone.add(new BookRespone(book.getId(), book.getTensach(), book.getNamXB(), book.isDeleteFlag(), book.getGioiThieu(),book.getNhaXB(),
						book.getTacGia().getId(), book.getTheLoai().getId(),book.getSoLuong(),book.getDonGia()));
			});
			return listBooksRespone;
		} catch (Exception e) {
			return null;
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
			BookEntity bookEntity = bookRepository.findOne(id);

			MessageRespone messageRespone = new MessageRespone();

			if (!bookEntity.isDeleteFlag()) {
				messageRespone.setMessage("Xóa sách thành công!");
			} 
			bookEntity.setDeleteFlag(true);
			bookRepository.save(bookEntity);
			return messageRespone;

		} catch (Exception e) {
			return new MessageRespone("Id của sách không tồn tại!");

		}

	}




	

}
