package com.quanlysach.payload.respone;

import java.util.Date;

/**
 * Export Respone
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
public class PhieuXuatRespone {
	private long id;
	
	private Date ngayNhap;

	private int tongTien;
	
	private boolean deleteFlag;
	
	private String tenNguoiNhan;
	
	private String diaChi;
	
	private String soDienThoai;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}

	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
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



	public PhieuXuatRespone(long id, Date ngayNhap, int tongTien, boolean deleteFlag, String tenNguoiNhan,
			String diaChi, String soDienThoai) {
		super();
		this.id = id;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
		this.deleteFlag = deleteFlag;
		this.tenNguoiNhan = tenNguoiNhan;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public PhieuXuatRespone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
