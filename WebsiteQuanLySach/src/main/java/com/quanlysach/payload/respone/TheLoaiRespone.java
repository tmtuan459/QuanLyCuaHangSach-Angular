package com.quanlysach.payload.respone;

/**
 * Type Respone
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
public class TheLoaiRespone {
	private long id;
	private String tenTheLoai;
	private String ghiChu;
	private boolean deleteFlag;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public TheLoaiRespone(long id, String tenTheLoai,String ghiChu, boolean deleteFlag) {
		super();
		this.id = id;
		this.tenTheLoai = tenTheLoai;
		this.ghiChu = ghiChu;
		this.deleteFlag = deleteFlag;
	}
	public TheLoaiRespone() {
		
	}
	
	
	
}

