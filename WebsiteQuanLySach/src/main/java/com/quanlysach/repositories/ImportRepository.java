package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.ImportEntity;
/**
 * PhieuNhapRepository
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
public interface ImportRepository extends CrudRepository<ImportEntity, Long> {
	/**
	 * find All Desc
	 * @return
	 */
	@Query("SELECT phieunhap FROM ImportEntity phieunhap WHERE phieunhap.deleteFlag=0 ORDER BY phieunhap.id DESC")//
	List<ImportEntity> findAllDesc();
	
	/**
	 * find phieu nhap by id of phieu nhap
	 * @param id
	 * @return
	 */
	@Query("SELECT phieunhap FROM ImportEntity phieunhap WHERE phieunhap.id =?1 and phieunhap.deleteFlag=0")
	ImportEntity findByIdPN(Long id);

	/**
	 * find phieu nhap cuoi cung
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM phieunhap i ORDER BY i.id desc limit 1")//co nativeQuery thi viet query theo sql
	ImportEntity findByIdLast();

	/**
	 * tinh tong tien nhap hang
	 * @return
	 */
	@Query(nativeQuery = true,value="select SUM(tongTien) FROM phieunhap")//co nativeQuery thi viet query theo sql, ten table khasc nhau
	Double tongTienNhapHang();
}
