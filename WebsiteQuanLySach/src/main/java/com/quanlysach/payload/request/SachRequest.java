package com.quanlysach.payload.request;




import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


/**
 * Book Request
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
public class SachRequest {
	

	@NotBlank(message = "Tên sách không thể để trống!")
	@Size(min = 1, max = 50,message = "Độ dài tên sách từ 1 đến 50")
	private String tensach;
	
	@NotNull(message = "Năm xuất bản không được trống")
	@Min(value = 1000,message = "Năm bắt đầu từ 1000")
	@Max(value = 2021,message = "Năm không lớn hơn năm hiện tại!")
	private int namXB;

	@Size(min = 1, max = 255,message = "Độ dài tên sách từ 1 đến 255")
	private String gioiThieu;
	
	@NotBlank(message = "Nhà xuất bản  không được trống")
	@Size(min = 1, max = 50,message = "Độ dài tên sách từ 1 đến 50")
	private String nhaXB;
	
	@NotNull(message = "Thể loại sách Id không được trống")
	private String theLoaiId;
	
	@NotNull(message = "Tác giả Id không được trống")
	private String tacGiaId;
	
	private int soLuong;
	

	private int donGia;
	
	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	
	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	





	public String getTheLoaiId() {
		return theLoaiId;
	}

	public void setTheLoaiId(String theLoaiId) {
		this.theLoaiId = theLoaiId;
	}

	public String getTacGiaId() {
		return tacGiaId;
	}

	public void setTacGiaId(String tacGiaId) {
		this.tacGiaId = tacGiaId;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	
	
}
