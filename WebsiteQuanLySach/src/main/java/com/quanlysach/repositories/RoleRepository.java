package com.quanlysach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlysach.entities.RoleEntity;
import com.quanlysach.entities.enums.ERole;
/**
 * RoleRepository
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
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	/**
	 * find ten phan quyen
	 * @param eRole
	 * @return
	 */
	RoleEntity findOneByNameAndDeleteFlagFalse(ERole eRole);
}
