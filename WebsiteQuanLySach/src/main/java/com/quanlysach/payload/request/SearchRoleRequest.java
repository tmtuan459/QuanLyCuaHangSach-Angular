package com.quanlysach.payload.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Search Role Request
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
public class SearchRoleRequest {
	@NotBlank(message = "roleId can not be left blank, Only accept patient-4,doctor-3,staff-2")
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	

}
