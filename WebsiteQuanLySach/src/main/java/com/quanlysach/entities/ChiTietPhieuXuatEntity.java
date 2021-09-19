package com.quanlysach.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * Chi Tiet Phieu Xuat Entity
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
@Table(name = "DetailPX")
public class ChiTietPhieuXuatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//set tự tăng
	private Long id;
	
	@Column
//	@JsonIgnore
	private boolean deleteFlag = false;

	
	@Column
	private int donGia;

	@Column
	private int soLuong;
	
	@Column(nullable = false, updatable = false)
	private Date ngayXuatCT;
	

	@JsonIgnore // PX
	@ManyToOne()
	@JoinColumn(name = "PX_id"
	, foreignKey = @ForeignKey(name = "fk_DPX_PX")
	// Annotation @ForeignKey cho phép chỉ định
																		
	)
	private PhieuXuatEntity phieuXuat;


    @OneToOne
	@JoinColumn(name = "maSach_id")
	private SachEntity maSachId;


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



	public PhieuXuatEntity getPhieuXuat() {
		return phieuXuat;
	}

	public void setPhieuXuat(PhieuXuatEntity phieuXuat) {
		this.phieuXuat = phieuXuat;
	}

	public SachEntity getMaSachId() {
		return maSachId;
	}

	public void setMaSachId(SachEntity maSachId) {
		this.maSachId = maSachId;
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

	public Date getNgayXuatCT() {
		return ngayXuatCT;
	}

	public void setNgayXuatCT(Date ngayXuatCT) {
		this.ngayXuatCT = ngayXuatCT;
	}



}
