package com.quanlysach.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Chi Tiet Phieu Nhap Entity
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
@Table(name = "DetailPN")
public class ChiTietPhieuNhapEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//set tự tăng
	private Long id;
	
	@Column
//	@JsonIgnore
	private boolean deleteFlag = false;
	
	@Column(nullable = false, updatable = false)
	private Date ngayNhapCT;
	
	@Column
	private int donGia;
	
	@Column
	private int soLuong;
	
	
	@JsonIgnore // PN
	@ManyToOne()
	@JoinColumn(name = "PN_id"
	, foreignKey = @ForeignKey(name = "fk_DPN_PN")// Annotation @ForeignKey cho phép chỉ định
												// rõ tên Foreign Key sẽ được tạo ra.
	)
	private PhieuNhapEntity phieuNhap;
	

    @OneToOne
	@JoinColumn(name = "maSach_id")
	private SachEntity maSach;


	public int getDonGia() {
		return donGia;
	}


	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public PhieuNhapEntity getPhieuNhap() {
		return phieuNhap;
	}


	public void setPhieuNhap(PhieuNhapEntity phieuNhap) {
		this.phieuNhap = phieuNhap;
	}


	public SachEntity getMaSach() {
		return maSach;
	}


	public void setMaSach(SachEntity maSach) {
		this.maSach = maSach;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public Date getNgayNhapCT() {
		return ngayNhapCT;
	}


	public void setNgayNhapCT(Date ngayNhapCT) {
		this.ngayNhapCT = ngayNhapCT;
	}



	



	
	
}
