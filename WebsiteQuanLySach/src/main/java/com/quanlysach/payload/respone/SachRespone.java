package com.quanlysach.payload.respone;

/**
 * Book Respone
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
public class SachRespone {

	private long id;

	private String tensach;

	private int namXB;

	private boolean deleteFlag;

	private String gioiThieu;
	private String nhaXB;

	private long tacGiaId;

	private long theLoaiId;
	

	private int soLuong;
	

	private int donGia;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

//	public long getTacGiaId() {
//		return tacGiaId;
//	}
//
//	public void setTacGiaId(long tacGiaId) {
//		this.tacGiaId = tacGiaId;
//	}
//
//	public long getTheLoaiId() {
//		return theLoaiId;
//	}
//
//	public void setTheLoaiId(long theLoaiId) {
//		this.theLoaiId = theLoaiId;
//	}


	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public SachRespone() {

	}

	




	public long getTacGiaId() {
		return tacGiaId;
	}

	public void setTacGiaId(long tacGiaId) {
		this.tacGiaId = tacGiaId;
	}

	public long getTheLoaiId() {
		return theLoaiId;
	}

	public void setTheLoaiId(long theLoaiId) {
		this.theLoaiId = theLoaiId;
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

	public SachRespone(long id, String tensach, int namXB, boolean deleteFlag, String gioiThieu, String nhaXB,
			long tacGiaId, long theLoaiId, int soLuong, int donGia) {
		super();
		this.id = id;
		this.tensach = tensach;
		this.namXB = namXB;
		this.deleteFlag = deleteFlag;
		this.gioiThieu = gioiThieu;
		this.nhaXB = nhaXB;
		this.tacGiaId = tacGiaId;
		this.theLoaiId = theLoaiId;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	

}
