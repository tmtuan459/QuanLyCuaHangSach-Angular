package com.quanlysach.payload.respone;

import java.util.Date;

/**
 * Import Respone
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
public class PhieuNhapRespone {
	private long id;
	
	private Date ngayNhap;

	private int tongTien;

	private boolean deleteFlag;

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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public boolean isDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public PhieuNhapRespone(long id, Date ngayNhap, int tongTien, boolean deleteFlag) {
		super();
		this.id = id;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
		this.deleteFlag = deleteFlag;
	}


	public PhieuNhapRespone() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
