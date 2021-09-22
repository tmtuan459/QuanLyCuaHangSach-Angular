package com.quanlysach.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User Entity
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
@Entity //khai báo đây là 1 entity thể hiện của table sau này t sẽ thao tác vào entity nào dl sẽ đc matching vs table mysql
@Table(name="user") // matching vs table user trong mysql
public class UserEntity {
	@Id
    @Column(unique = true,columnDefinition = "CHAR(100)")
    private String userName;

    @Column(length = 60)
    private String password;

    @Column
    private String fullName;

    @Column
    private String address;

    @Column
    private String phoneNumber;
    
    @Column
    private String email;

    
    @Column
    private boolean gender;
    
    

    @Column
    private boolean enable = true;
    
    @Column
    private boolean isDeleted = false;
    
    @JsonIgnore
	//Khai báo manytoone, nếu 1 bên có dạng như này thì bên kia dạng khác 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id"//tên bảng đc sinh ra
		,foreignKey = @ForeignKey(name = "fk_user_role")
    )
	private RoleEntity role;
    
    @JsonIgnore
 	@OneToMany(fetch = FetchType.LAZY,mappedBy = "staffId")
    private Set<ImportEntity> phieunhap;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "staff")
    private Set<ExportEntity> phieuxuat;
    
    
	

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public Set<ImportEntity> getPhieunhap() {
		return phieunhap;
	}

	public void setPhieunhap(Set<ImportEntity> phieunhap) {
		this.phieunhap = phieunhap;
	}

	public Set<ExportEntity> getPhieuxuat() {
		return phieuxuat;
	}

	public void setPhieuxuat(Set<ExportEntity> phieuxuat) {
		this.phieuxuat = phieuxuat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	

}
