package com.quanlysach.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.ChiTietPhieuXuatEntity;
/**
 * ChiTietPhieuXuatRepository
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
public interface ChiTietPhieuXuatRepository extends CrudRepository<ChiTietPhieuXuatEntity, Long> {
	
	/**
	 * List Phieu Xuat
	 * @return list phieu xuat
	 */
	@Query(nativeQuery = true, value ="select month(px.ngay_xuat) as \"Tháng\" , sum(dpx.so_luong) as \"Số lượng bán\",sum(dpx.don_gia * dpx.so_luong) as \"Tổng tiền xuất\",sum((dpx.don_gia * dpx.so_luong)-(bk.don_gia * dpx.so_luong)) as \"Lợi nhuận\"\r\n"
			+ "from detailpx dpx join phieuxuat px on dpx.px_id=px.id left join book bk on dpx.ma_sach_id=bk.id where year(px.ngay_xuat)=year(now())\r\n"
			+ "group by month(px.ngay_xuat);")
	List<?> ListPhieuXuat();
	
	@Query(nativeQuery = true, value="select  bk.tensach as \"Tên sách\",sum(dpx.so_luong)  as \"Số lượng bán\",sum(dpx.don_gia * dpx.so_luong) as \"Tổng tiền xuất\",sum((dpx.don_gia * dpx.so_luong)-(bk.don_gia * dpx.so_luong)) as \"Lợi nhuận\"\r\n"
			+ "from detailpx dpx join book bk on dpx.ma_sach_id=bk.id\r\n"
			+ "group by (dpx.ma_sach_id) \r\n"
			+ "order by dpx.id  DESC")
	List<?>ListDoanhThuTheoSach();
	
	@Query(nativeQuery = true, value="select  bk.tensach as \"Tên sách\",dpx.so_luong  as \"Số lượng xuất\", dpx.don_gia as \"Đơn giá\", Date(dpx.ngay_xuatct) as \" Ngày xuất\"\r\n"
			+ "from detailpx dpx join book bk on dpx.ma_sach_id=bk.id\r\n"
			+ "order by dpx.ngay_xuatct  DESC")
	List<?>ListChiTietDonXuat();
	
}
