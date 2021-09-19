package com.quanlysach.payload.respone;

/**
 * Api Respone
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
public class ApiRespone {
	private int status;

	private String message;

	private String error;

	public String getError() {
		return error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ApiRespone(int status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
	}

	public ApiRespone() {


	}
	
}
