package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.SachEntity;
/**
 * SachRepository
 * 
 * Version 1.0
 * 
 * Date 19-08-2021
 * 
 * Modification Logs:
 * 
 * * DATE AUTHOR DESCRIPTION --------------------------------------------------
 * 
 * 17-09-2021 TuanTM24 Create
 */
@Repository
public interface SachRepository extends JpaRepository<SachEntity, Long>{
	
	/**
	 * find list book
	 * @return list book
	 */
	@Query(nativeQuery = true,value="select * from book where book.delete_flag=0 ORDER BY book.id DESC")
	List<SachEntity> listAllBook();
	
	/**
	 * find book theo ten sach
	 * @param tensach
	 * @return book
	 */
	@Query("SELECT book FROM SachEntity book WHERE book.tensach = ?1")// da ton tai hay chua
	SachEntity findByTenSach(String tensach);
	
	/**
	 * find book theo ten tac gia
	 * @param idAuthor
	 * @return list book
	 */
	@Query("SELECT book FROM SachEntity book WHERE book.tacGia.id =?1")//auto map ss param ?1 vij tri param
	List<SachEntity> findBookByAuthor(Long idAuthor);
	
	/**
	 * find book theo ten the loai
	 * @param idType
	 * @return list book
	 */
	@Query("SELECT book FROM SachEntity book WHERE book.theLoai.id =?1")//auto map ss param ?1 vij tri param
	List<SachEntity> findBookByType(Long idType);
	
	/**
	 * find id by ten sach
	 * @param tensach
	 * @return
	 */
    @Query("SELECT book FROM SachEntity book WHERE id=?1")
    SachEntity findIdByTenSach(String tensach);
	
    /**
     * find All Book By Delete Flag True
     * @return
     */
	@Query(nativeQuery = true,value="select * from book")
	List<SachEntity> findAllByDeleteFlagTrue();
	
	/**
     * find Book Insufficient
     * @return list book Insufficient
     */
	@Query(nativeQuery = true,value="select * from book where book.so_luong<30 and book.delete_flag=0 order by book.so_luong ASC ")
	List<SachEntity> listBookInsufficient();//book het hang <10
	
	/**
     * find Book Redundant
     * @return list book list Book Redundant
     */
	@Query(nativeQuery = true,value="select * from book where book.so_luong>50 and book.delete_flag=0 order by book.so_luong DESC ")
	List<SachEntity> listBookRedundant();//book con du >50
	
	


}
