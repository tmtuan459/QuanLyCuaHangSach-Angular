//package com.quanlysach.securities;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.quanlysach.entities.UserEntity;
//
//
//public class MyUserDetails implements UserDetails{
//	
//	public MyUserDetails(UserEntity user) {
//		super();
//		this.user = user;
//	}
//	
//	public MyUserDetails() {
//
//	
//	}
//
//	private static final long serialVersionUID = 1L;
//	private UserEntity user;
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		 SimpleGrantedAuthority authority= new SimpleGrantedAuthority(user.getRole().getName().toString());
//	        return Collections.singletonList(authority);
//	}
//
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return user.getUserName();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return user.isEnable();
//	}
//
//	public String getFullName(){
//        return user.getFullName();
//    }
//	
//    public  String getAddress(){
//    	return user.getAddress();
//	}
//
//	
//	
//}
