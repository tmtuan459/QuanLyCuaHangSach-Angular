//package com.quanlysach.services.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.quanlysach.convert.UserConvert;
//import com.quanlysach.entities.RoleEntity;
//import com.quanlysach.entities.UserEntity;
//import com.quanlysach.entities.enums.ERole;
//import com.quanlysach.payload.request.UserRequest;
//import com.quanlysach.repositories.RoleRepository;
//import com.quanlysach.repositories.UserRepository;
//
//
//
//
//
//
//
//
//@Service //ở api muốn xài @Autowire gọi lớp service này thì phải có cái anotation này nó mới hiểu
//public class UserService implements IUserService{
//	@Autowired
//    PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private UserConvert userConvert;
//	
//	@Override
//	public UserEntity createNewPatient(UserRequest userRequest) {
//
//		RoleEntity role = roleRepository.findOneByNameAndDeleteFlagFalse(ERole.ROLE_ADMIN);
//		return userRepository.save(userConvert.toUserEntity(userRequest, role));
//	}
//
////	@Override
////	public UserEntity createNewStaff(UserRequest staffRequest) {
////		return null;
////	}
////
////	@Override
////	public ResponseEntity<Object> changePassword(UserEntity user, PasswordRequest passwordRequest) {
////		return null;
////	}
////
////	@Override
////	public ResponseEntity<Object> updateUser(String userName, UserUpdateRequest userUpdateRequest) {
////		return null;
////	}
////
////	@Override
////	public MessageRespone toggleEnableByUserName(String userName) {
////		return null;
////	}
////
////	@Override
////	public MessageRespone toggleIsDeleteByUserName(String userName) {
////		return null;
////	}
////
////	@Override
////	public List<ListCustomUserRespone> findAllByRoleSearchAndIsDeleteFalse(SearchRoleRequest roleSearch) {
////		return null;
////	}
////
////	@Override
////	public ResponseEntity<Object> changePasswordByEmail(UserEntity user, String newPassword) {
////		return null;
////	}
//	
//}
