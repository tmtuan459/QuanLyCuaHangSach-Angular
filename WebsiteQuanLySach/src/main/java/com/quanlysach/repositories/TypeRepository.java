package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.TypeEntity;
/**
 * TheLoaiRepository
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
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
	
	/**
	 * find All By Delete Flag False
	 * @return
	 */
	@Query(nativeQuery = true,value="select * from type where type.delete_flag=0 ORDER BY type.id DESC")
	List<TypeEntity> findAllByDeleteFlagFalse();
		
	/**
	 * find By Ten The Loai
	 * @param tenTheLoai
	 * @return
	 */
	@Query("SELECT type FROM TypeEntity type WHERE type.tenTheLoai = ?1")
	TypeEntity findByNameType(String typeName);
	
	

}
