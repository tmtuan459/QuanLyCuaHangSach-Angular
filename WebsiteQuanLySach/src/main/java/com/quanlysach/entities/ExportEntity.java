package com.quanlysach.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Phieu Xuat Entity
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
@Entity
@Table(name = "phieuxuat")
public class ExportEntity extends BaseEntity{
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
	private Date ngayXuat;
	
	private int tongTien;
	
	private String diaChi;
	
	private String soDienThoai;
	
	private String tenNguoiNhan;
	

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id"
	, foreignKey = @ForeignKey(name = "fk_PX_user_staff")
	)
	private UserEntity staff;

	// detail PN nên jsoningore
	// hiển thị PN thì cái này k cần
	@OneToMany(mappedBy = "phieuXuat", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExportDetailEntity> chiTietPhieuXuat;

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public UserEntity getStaff() {
		return staff;
	}

	public void setStaff(UserEntity staff) {
		this.staff = staff;
	}

	public Set<ExportDetailEntity> getChiTietPhieuXuat() {
		return chiTietPhieuXuat;
	}

	public void setChiTietPhieuXuat(Set<ExportDetailEntity> chiTietPhieuXuat) {
		this.chiTietPhieuXuat = chiTietPhieuXuat;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}

	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	
	
}
