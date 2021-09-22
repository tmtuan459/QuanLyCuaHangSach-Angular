package com.quanlysach.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Loai Entity
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
@Table(name="type")
public class TypeEntity extends BaseEntity {

	@Column
	private String tenTheLoai;
	@Column
	private String ghiChu;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theLoai")
	private Set<BookEntity> sach;

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public Set<BookEntity> getSach() {
		return sach;
	}

	public void setSach(Set<BookEntity> sach) {
		this.sach = sach;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
