package com.quanlysach.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quanlysach.entities.enums.ERole;

/**
 * Role Entity
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
@Table(name = "role")
public class RoleEntity extends BaseEntity{
	@Column
    @Enumerated(EnumType.STRING)
    private ERole name;
	
	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
	
	//Mapping to user
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserEntity> users ;

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
	
	
}
