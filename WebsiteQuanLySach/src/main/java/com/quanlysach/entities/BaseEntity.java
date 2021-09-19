package com.quanlysach.entities;


//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Base Entity
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
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//set datetime tự động khi create or update
public class BaseEntity {
	
		
		@Id
		//set tự tăng
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		//Dùng để ám định là record này có bị xóa hay không, dữ liệu vẫn còn nhưng k đem xóa.//xóa logic
		@Column
//		@JsonIgnore
		private boolean deleteFlag = false;

		
		
//		@Column
//		@CreatedBy
//		private String createdBy;
//		
//		@Column
//		@CreationTimestamp
//		private Date createdAt;
//		
//		@Column
//		@LastModifiedBy
//		private String updateBy;
//		
//		@Column
//		@UpdateTimestamp
//		private Date updateAt;
		
//		public String getCreatedBy() {
//			return createdBy;
//		}
//
//		public void setCreatedBy(String createdBy) {
//			this.createdBy = createdBy;
//		}
//
//		public Date getCreatedAt() {
//			return createdAt;
//		}
//
//		public void setCreatedAt(Date createdAt) {
//			this.createdAt = createdAt;
//		}
//
//		public String getUpdateBy() {
//			return updateBy;
//		}
//
//		public void setUpdateBy(String updateBy) {
//			this.updateBy = updateBy;
//		}
//
//		public Date getUpdateAt() {
//			return updateAt;
//		}
//
//		public void setUpdateAt(Date updateAt) {
//			this.updateAt = updateAt;
//		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public boolean isDeleteFlag() {
			return deleteFlag;
		}

		public void setDeleteFlag(boolean deleteFlag) {
			this.deleteFlag = deleteFlag;
		}
		
		
		
}
