//package com.quanlysach.securities;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.quanlysach.entities.UserEntity;
//import com.quanlysach.repositories.UserRepository;
//
//
//
//
//
//@Component
//public class MyUserDetailsServiceImpl implements UserDetailsService{
//	@Autowired
//    UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserEntity user;
//		try {
//			user = userRepository.findOne(username);
//		}catch(Exception e) {
//			user = null;
//		}
//		if (user == null){
//            throw new UsernameNotFoundException("could not find by user!");
//        }
//		return new MyUserDetails(user);
//	}
//	
//}
