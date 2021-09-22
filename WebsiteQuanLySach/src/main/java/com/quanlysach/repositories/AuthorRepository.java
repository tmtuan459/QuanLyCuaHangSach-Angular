package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.AuthorEntity;
/**
 * TacGiaRepository
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
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>{
	/**
	 * Find All Tac Gia By Delete Flag False
	 * @return List Tac Gia
	 */
	@Query(nativeQuery = true,value="select * from author where author.delete_flag=0 ORDER BY author.id DESC")
	List<AuthorEntity> findAllByDeleteFlagFalse();
	

//	@Query("SELECT i FROM TacGiaEntity i WHERE i.deleteFlag=0 ORDER BY i.id DESC")
//	List<TacGiaEntity> findAllByDeleteFlag();
	
	/**
	 * find By Ten Tac Gia
	 * @param tenTacGia
	 * @return Tac Gia
	 */
	@Query("SELECT a FROM AuthorEntity a WHERE a.tenTacGia = ?1")//
	AuthorEntity findByNameAuthor(String tenTacGia);
	
	/**
	 * Find Exist Note
	 * @param ghiChu
	 * @return Tac Gia
	 */
	@Query("SELECT a FROM AuthorEntity a WHERE a.ghiChu = ?1")//
	AuthorEntity findExistNote(String ghiChu);
	

}
