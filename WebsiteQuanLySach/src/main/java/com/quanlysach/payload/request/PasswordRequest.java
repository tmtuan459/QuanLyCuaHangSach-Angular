package com.quanlysach.payload.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Password Request
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
public class PasswordRequest {
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@NotBlank(message = "currentPassword cannot be left blank!")
	private String currentPassword;
	@NotBlank(message = "newPassword cannot be left blank!")
	private String newPassword;
}
