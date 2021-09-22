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
 * Tac Gia Entity
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
@Table(name="author")//ten table se tao trong mysql
public class AuthorEntity extends BaseEntity{
	
	@Column
	private String tenTacGia;
	@Column
	private String ghiChu;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tacGia")
	private Set<BookEntity> sach;
	
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
	public Set<BookEntity> getSach() {
		return sach;
	}
	public void setSach(Set<BookEntity> sach) {
		this.sach = sach;
	}

	
	
}
