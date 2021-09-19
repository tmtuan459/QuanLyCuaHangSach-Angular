package com.quanlysach.payload.respone;

import java.util.Date;

/**
 * List Custom User Respone
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
public class ListCustomUserRespone {
	private String userName;

	 
    private String fullName;

    
    private String address;

   
    private String phoneNumber;
    

    private String avatar;


    private boolean enable = true;


    private String email;


    private int experience;
    

    private String specialized;
    

    private boolean isDeleted = false;
    

    private boolean gender;
	

    private Date createdAt;


    private Date updatedAt;
    

    private Date dateOfBirth;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public boolean isEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getSpecialized() {
		return specialized;
	}


	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public boolean isGender() {
		return gender;
	}


	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public ListCustomUserRespone(String userName, String fullName, String address, String phoneNumber, String avatar,
			boolean enable, String email, int experience, String specialized, boolean isDeleted, boolean gender,
			Date createdAt, Date updatedAt, Date dateOfBirth) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.avatar = avatar;
		this.enable = enable;
		this.email = email;
		this.experience = experience;
		this.specialized = specialized;
		this.isDeleted = isDeleted;
		this.gender = gender;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dateOfBirth = dateOfBirth;
	}


	public ListCustomUserRespone() {
		
		// TODO Auto-generated constructor stub
	}
    

}
