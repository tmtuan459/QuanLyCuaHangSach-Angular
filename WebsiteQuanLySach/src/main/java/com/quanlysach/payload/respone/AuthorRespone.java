package com.quanlysach.payload.respone;

/**
 * Author Respone
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
public class AuthorRespone {
	private long id;
	private String tenTacGia;
	private String ghiChu;
	private boolean deleteFlag;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public AuthorRespone(long id, String tenTacGia, String ghiChu, boolean deleteFlag) {
		super();
		this.id = id;
		this.tenTacGia = tenTacGia;
		this.ghiChu = ghiChu;
		this.deleteFlag = deleteFlag;
	}
	public AuthorRespone() {
		
	}
	
		

}
