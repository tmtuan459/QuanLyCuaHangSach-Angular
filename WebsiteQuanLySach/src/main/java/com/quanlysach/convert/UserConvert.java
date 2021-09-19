//package com.quanlysach.convert;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.quanlysach.entities.RoleEntity;
//import com.quanlysach.entities.UserEntity;
//import com.quanlysach.payload.request.UserRequest;
//
//
//
//@Component//tựa như @service và repository để bên kia @Autowire lấy đc cái này.
//public class UserConvert {
//	@Autowired
//    PasswordEncoder passwordEncoder;
//	
//
//	public UserEntity toUserEntity(UserRequest userRequest, RoleEntity role){
//		UserEntity user = new UserEntity();
//        user.setUserName(userRequest.getUserName());
//        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//        user.setFullName(userRequest.getFullName());
//        user.setAddress(userRequest.getAddress());
//        user.setGender(userRequest.isGender());
//        user.setPhoneNumber(userRequest.getPhoneNumber());
//        user.setEmail(userRequest.getEmail());
//        user.setRole(role);
//        return user;
//    }
//	
////	public UserEntity toUserEntityDoctor(DoctorRequest doctorRequest, RoleEntity role){
////		UserEntity user = new UserEntity();
////		user.setExperience(doctorRequest.getExperience());
////		user.setSpecialized(doctorRequest.getSpecialized());
////        user.setUserName(doctorRequest.getUserName());
////        user.setPassword(passwordEncoder.encode(doctorRequest.getPassword()));
////        user.setFullName(doctorRequest.getFullName());
////        user.setAddress(doctorRequest.getAddress());
////        user.setGender(doctorRequest.isGender());
////        user.setPhoneNumber(doctorRequest.getPhoneNumber());
////        user.setEmail(doctorRequest.getEmail());
////        user.setRole(role);
////        return user;
////    }
//
//}
