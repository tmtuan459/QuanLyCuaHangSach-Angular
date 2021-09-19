//package com.quanlysach.controllers;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.quanlysach.payload.request.RoleRequest;
//import com.quanlysach.services.IRole;
//
//@CrossOrigin(origins="http://localhost:4200")// fix block by CORS
//@RestController
//@RequestMapping("/api/v1/role")
//public class RoleController {
//	@Autowired
//	private IRole roleService;
//	
//	@PostMapping("/create")
//	public ResponseEntity<Object> createRole(@RequestBody @Valid RoleRequest roleReuqest) {
//
//		return ResponseEntity.ok(roleService.createRole(roleReuqest));
//	}
//}
