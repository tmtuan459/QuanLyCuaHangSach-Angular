package com.quanlysach.payload.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User Request
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
public class UserRequest {
	//Đây là request dk gửi lên từ client
	
		@Pattern(regexp="^[a-zA-Z0-9]+",message = "username cannot be include special charecter")
		@NotBlank(message = "username cannot be left blank")
		@Size(min=6,max=20,message = "username size must be between 6 and 20")
		private String userName;
		
		@NotBlank(message = "fullName cannot be left blank")
		private String fullName;
		
	    @Size(min = 6,max = 16,message = "password size must be between 6 and 16")
		private String password;
		
		@Email(message = "email is invalid")
		@NotBlank(message = "email cannot be left blank")
		private String email;
		
		@NotNull(message = "gender cannot be null, only accept true or false")
		private boolean gender;

		@NotBlank(message = "address cannot be left blank")
		private String address;
		
//		@Size(min = 9, max = 11,message = "phoneNumber size must be between 9 and 11")
		@Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$+",message = "phoneNumber is invalid")
		//@Pattern(regexp = "^0(1\\d{9}|9\\d{8}|3\\d{8}|7\\d{8})$+",message = "phoneNumber is invalid")
		private String phoneNumber;

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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isGender() {
			return gender;
		}

		public void setGender(boolean gender) {
			this.gender = gender;
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
		
}
