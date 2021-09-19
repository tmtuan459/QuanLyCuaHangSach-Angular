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
public class SachEntity extends BaseEntity {

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
	private TacGiaEntity tacGia;

	

	@JoinColumn(name = "theLoai_id")
	@ManyToOne()
	private TheLoaiEntity theLoai;

	@JsonIgnore
	@OneToMany(mappedBy = "maSach")
    private List<ChiTietPhieuNhapEntity> chiTietPhieuNhapId ;


	@JsonIgnore
	@OneToMany(mappedBy = "maSachId")
    private List<ChiTietPhieuXuatEntity> chiTietPhieuXuatId;

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





	public TacGiaEntity getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGiaEntity tacGia) {
		this.tacGia = tacGia;
	}

	public TheLoaiEntity getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoaiEntity theLoai) {
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

	public List<ChiTietPhieuNhapEntity> getChiTietPhieuNhapId() {
		return chiTietPhieuNhapId;
	}

	public void setChiTietPhieuNhapId(List<ChiTietPhieuNhapEntity> chiTietPhieuNhapId) {
		this.chiTietPhieuNhapId = chiTietPhieuNhapId;
	}

	public List<ChiTietPhieuXuatEntity> getChiTietPhieuXuatId() {
		return chiTietPhieuXuatId;
	}

	public void setChiTietPhieuXuatId(List<ChiTietPhieuXuatEntity> chiTietPhieuXuatId) {
		this.chiTietPhieuXuatId = chiTietPhieuXuatId;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	

}
