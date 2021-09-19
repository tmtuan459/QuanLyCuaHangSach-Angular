package com.quanlysach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quanlysach.entities.UserEntity;
/**
 * UserRepository
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
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	/**
	 * find By Email
	 * @param Email
	 * @return Email
	 */
	UserEntity findByEmail(String Email);
	
	/**
	 * check exists By Email
	 * @param Email
	 * @return Email
	 */
	boolean existsByEmail(String Email);
//	List<UserEntity> findByEnableTrueAndIsDeletedFalse();// dat the ten column trong User entit. no' tu. dong tim ra dc
//	List<UserEntity> findByEnableFalseAndIsDeletedFalse();
//	List<UserEntity> findAllByIsDeletedFalse();
//	List<UserEntity> findByFullNameContaining(String name);
//
//	List<UserEntity> findByRoleAndIsDeletedFalse(RoleEntity role);
}
