package com.quanlysach.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Sach Entity
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
@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {

	@Column
	private String tensach;

	@Column
	private int namXB;

	@Column
	private String gioiThieu;
	@Column
	private String nhaXB;
	
	@Column
	private int soLuong;
	
	@Column
	private int donGia;

	
	@JoinColumn(name = "tacGia_id")
	@ManyToOne()
	private AuthorEntity tacGia;

	

	@JoinColumn(name = "theLoai_id")
	@ManyToOne()
	private TypeEntity theLoai;

	@JsonIgnore
	@OneToMany(mappedBy = "maSach")
    private List<ImportDetailpEntity> chiTietPhieuNhapId ;


	@JsonIgnore
	@OneToMany(mappedBy = "maSachId")
    private List<ExportDetailEntity> chiTietPhieuXuatId;

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





	public AuthorEntity getTacGia() {
		return tacGia;
	}

	public void setTacGia(AuthorEntity tacGia) {
		this.tacGia = tacGia;
	}

	public TypeEntity getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TypeEntity theLoai) {
		this.theLoai = theLoai;
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

	public List<ImportDetailpEntity> getChiTietPhieuNhapId() {
		return chiTietPhieuNhapId;
	}

	public void setChiTietPhieuNhapId(List<ImportDetailpEntity> chiTietPhieuNhapId) {
		this.chiTietPhieuNhapId = chiTietPhieuNhapId;
	}

	public List<ExportDetailEntity> getChiTietPhieuXuatId() {
		return chiTietPhieuXuatId;
	}

	public void setChiTietPhieuXuatId(List<ExportDetailEntity> chiTietPhieuXuatId) {
		this.chiTietPhieuXuatId = chiTietPhieuXuatId;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	

}
