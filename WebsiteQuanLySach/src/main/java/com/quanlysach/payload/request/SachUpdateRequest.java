package com.quanlysach.payload.request;



import javax.validation.constraints.NotNull;

/**
 * Book Update Request
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
public class SachUpdateRequest {
	
	@NotNull(message = "Id không thể trống!")
	private Long id;
	

//	@NotBlank(message = "Tên sách không thể để trống!")
//	@Size(min = 1, max = 250,message = "Tên Sách độ dài từ 1 đến 200")
//	private String tensach;
//	
	


	private String gioiThieu;
	

	
	
	@NotNull(message = "Tác giả không thể trống!")
	private String tacGiaId;
	
	@NotNull(message = "Thể loại không thể trống!")
	private String theLoaiId;
	

//	@Size(min = 1, max = 9999,message = "Năm xuất bản từ 1 đến 9999 ")
	private int namXB;
	
	private String nhaXB;
	
	private int soLuong;
	

	private int donGia;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getTensach() {
//		return tensach;
//	}
//
//	public void setTensach(String tensach) {
//		this.tensach = tensach;
//	}






	public int getNamXB() {
		return namXB;
	}



	public String getTacGiaId() {
		return tacGiaId;
	}

	public void setTacGiaId(String tacGiaId) {
		this.tacGiaId = tacGiaId;
	}

	public String getTheLoaiId() {
		return theLoaiId;
	}

	public void setTheLoaiId(String theLoaiId) {
		this.theLoaiId = theLoaiId;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}




	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
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

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}
 
	
	
	
	
}
