package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.ImportDetailpEntity;
/**
 * ChiTietPhieuNhapRepository
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
public interface ImportDetailRepository extends CrudRepository<ImportDetailpEntity, Long>{
	/**
	 * list danh sach 
	 * @return list danh sach don nhap chi tiet
	 */
	@Query(nativeQuery = true, value="select  bk.tensach as \"Tên sách\",dpn.so_luong  as \"Số lượng nhập\", dpn.don_gia as \"Đơn giá\", Date(dpn.ngay_nhapct)  as \" Ngày nhập\"\r\n"
			+ "from detailpn dpn join book bk on dpn.ma_sach_id=bk.id\r\n"
			+ "order by dpn.ngay_nhapct  DESC")
	List<?>ListImportDetail();

}
