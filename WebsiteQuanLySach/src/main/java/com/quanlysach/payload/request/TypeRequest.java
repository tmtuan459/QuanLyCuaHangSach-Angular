package com.quanlysach.payload.request;



import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Type Request
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
public class TypeRequest {
	
	@NotBlank(message = "Tên thể loại sách không được để trống!")
	@Size(min = 1, max = 30,message = "Độ dài tên từ 1 đến 30")
	private String tenTheLoai;
	
	@Size(min = 1, max = 255,message = "Độ dài ghi chú từ 1 đến 255")
	private String ghiChu;
	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
	
}
