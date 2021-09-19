package com.quanlysach.payload.request;

import javax.validation.constraints.NotNull;

/**
 * Author Update Request
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
public class TacGiaUpdateRequest {
	
	@NotNull(message = "Id không thể trống!")
	private Long id;
//	
//	@NotBlank(message = "Tên tác giả không được để trống!")
//	@Size(min = 1, max = 250,message = "Tên tác giả dài từ 1 đến 250 ky tu")
//	private String tenTacGia;

	private String ghiChu;

//	public String getTenTacGia() {
//		return tenTacGia;
//	}
//
//	public void setTenTacGia(String tenTacGia) {
//		this.tenTacGia = tenTacGia;
//	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
