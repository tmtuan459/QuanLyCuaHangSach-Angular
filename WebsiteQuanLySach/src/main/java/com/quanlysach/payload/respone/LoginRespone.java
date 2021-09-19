package com.quanlysach.payload.respone;

/**
 * Login Respone
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
public class LoginRespone {
	private String username;
	
	private String accsessToken;
	
	private String tokenType ="Bearer ";
	
	private String address;
	
	private String fullname;
	
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccsessToken() {
		return accsessToken;
	}

	public void setAccsessToken(String accsessToken) {
		this.accsessToken = accsessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginRespone(String username, String accsessToken, String address, String fullname,
			String role) {
		super();
		this.username = username;
		this.accsessToken = accsessToken;

		this.address = address;
		this.fullname = fullname;
		this.role = role;
	}

	public LoginRespone() {
	
		// TODO Auto-generated constructor stub
	}
	
}
