package com.quanlysach.payload.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Role Request
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
public class RoleRequest {
	@NotBlank(message = "Tên Role sách không được để trống!")
	@Size(min = 1, max = 200,message = "name size must be between 1 and 200")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
