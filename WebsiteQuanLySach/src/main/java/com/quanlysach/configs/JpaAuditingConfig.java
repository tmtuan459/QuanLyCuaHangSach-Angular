//package com.quanlysach.configs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//
//@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider") //
//public class JpaAuditingConfig {
//	@Bean
//	public AuditorAware<String> auditorProvider() {
//		return new AuditorAwareImpl();
//	}
//	public static class AuditorAwareImpl implements AuditorAware<String> {
//		@Override
//		public String getCurrentAuditor() {
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//			if (authentication == null || !authentication.isAuthenticated()) {//khác null và đã đăng nhập r
//				return null;
//			}
//			return authentication.getName(); //Lấy người đang hoạt động trong hệ thống để set
//		}
//	}
//
//}
