//package com.quanlysach.services.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.quanlysach.convert.RoleConvert;
//import com.quanlysach.entities.RoleEntity;
//import com.quanlysach.entities.TheLoaiEntity;
//import com.quanlysach.payload.request.RoleRequest;
//import com.quanlysach.repositories.RoleRepository;
//import com.quanlysach.repositories.TacGiaRepository;
//import com.quanlysach.services.IRole;
//
//@Service
//public class RoleService implements IRole{
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private RoleConvert roleConvert;
//	
//
//	@Override
//	public RoleEntity createRole(RoleRequest roleRequest) {
//		return roleRepository.save(roleConvert.toEntity(roleRequest));
//	}
//	
//
//}
