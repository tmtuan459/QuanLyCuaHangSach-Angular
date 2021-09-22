package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.ExportEntity;
/**
 * PhieuXuatRepository
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
public interface ExportRepository extends CrudRepository<ExportEntity, Long>{
	
	/**
	 * find all danh sach phieu xuat
	 * @return list
	 */
	@Query("SELECT phieuxuat FROM ExportEntity phieuxuat WHERE phieuxuat.deleteFlag=0 ORDER BY phieuxuat.id DESC")//
	List<ExportEntity> findAllDesc();

	/**
	 * find phieu xuat by id
	 * @param id
	 * @return phieu xuat
	 */
	@Query("SELECT phieuxuat FROM ExportEntity phieuxuat WHERE phieuxuat.id =?1 and phieuxuat.deleteFlag=0")
	ExportEntity findByIdExport(Long id);

	/**
	 * find phieu xuat cuoi cung
	 * @return phieu xuat cuoi cung
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM phieuxuat i ORDER BY i.id desc limit 1")//co nativeQuery thi viet query theo sql
	ExportEntity findByIdLast();

	/**
	 * tinh tong tien xuat hang
	 * @return tong tien xuat hang
	 */
	@Query(nativeQuery = true,value="select SUM(tongTien) FROM phieuxuat")//co nativeQuery thi viet query theo sql, ten table khasc nhau
	Double Total();
}
