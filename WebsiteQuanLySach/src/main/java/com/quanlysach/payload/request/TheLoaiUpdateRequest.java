package com.quanlysach.payload.request;

import javax.validation.constraints.NotNull;

/**
 * Type Update Request
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
public class TheLoaiUpdateRequest {
	@NotNull(message = "Id không thể trống!")
	private Long id;
	
//	@NotBlank(message = "Tên thể loại sách không được để trống!")
//	@Size(min = 1, max = 200,message = "name size must be between 1 and 200")
//	private String tenTheLoai;


	private String ghiChu;

//	public String getTenTheLoai() {
//		return tenTheLoai;
//	}
//
//	public void setTenTheLoai(String tenTheLoai) {
//		this.tenTheLoai = tenTheLoai;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	
	
}
