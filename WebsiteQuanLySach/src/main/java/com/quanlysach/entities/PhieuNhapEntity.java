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

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Phieu Nhap Entity
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
@Table(name = "phieunhap")
public class PhieuNhapEntity extends BaseEntity {

	@Column(nullable = false, updatable = false)
//	@CreatedDate
	private Date ngayNhap;
	
	private int tongTien;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id"
	, foreignKey = @ForeignKey(name = "fk_PN_user_staff")
	)
	private UserEntity staffId;

	// detail PN nên jsoningore
	// hiển thị PN thì cái này k cần
	@OneToMany(mappedBy = "phieuNhap", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ChiTietPhieuNhapEntity> chiTietPhieuNhap;

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	

	public UserEntity getStaffId() {
		return staffId;
	}

	public void setStaffId(UserEntity staffId) {
		this.staffId = staffId;
	}

	public Set<ChiTietPhieuNhapEntity> getChiTietPhieuNhap() {
		return chiTietPhieuNhap;
	}

	public void setChiTietPhieuNhap(Set<ChiTietPhieuNhapEntity> chiTietPhieuNhap) {
		this.chiTietPhieuNhap = chiTietPhieuNhap;

	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

}
