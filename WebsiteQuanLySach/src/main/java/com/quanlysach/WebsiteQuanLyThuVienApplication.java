package com.quanlysach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebsiteQuanLyThuVienApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteQuanLyThuVienApplication.class, args);
	}

}
