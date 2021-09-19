//package com.quanlysach.controllers;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.quanlysach.repositories.UserRepository;
//import com.quanlysach.securities.JwtTokenProvider;
//import com.quanlysach.securities.MyUserDetails;
//import com.quanlysach.services.impl.IUserService;
//import com.quanlysach.payload.request.LoginRequest;
//import com.quanlysach.payload.request.UserRequest;
//import com.quanlysach.payload.respone.ApiRespone;
//import com.quanlysach.payload.respone.LoginRespone;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//
//
//@CrossOrigin// fix block by CORS
//@RestController
//@RequestMapping(value = "/api/v1/auth")
//@Api
//public class AuthController {
//	@Autowired
//	private IUserService userService;
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	@Autowired
//	private JwtTokenProvider jwtTokenProvider; 
//	@Autowired
//	private UserRepository userRepository;
//	
//	//Đăng ký member
//	@PostMapping("/register")
//	@ApiOperation(value = "Đăng ký member")
//	public ResponseEntity<Object> createNewAccountMember(@RequestBody @Valid UserRequest userRequest){
//		if(userRepository.exists(userRequest.getUserName())) {
//			return new ResponseEntity<>(new ApiRespone(400,"Bad Request","UserName already exists! Please use another UserName!"),HttpStatus.BAD_REQUEST);
//		}
//		if(userRepository.existsByEmail(userRequest.getEmail())) {
//			return new ResponseEntity<>(new ApiRespone(400,"Bad Request","Email already exists! Please use another email!"),HttpStatus.BAD_REQUEST);
//		}
//		
//		
//		return ResponseEntity.ok(userService.createNewPatient(userRequest));
//	}
//	
//	//Đăng nhập
//	@PostMapping("/signIn")
//	@ApiOperation(value = "Đăng nhập")
//	public ResponseEntity<Object> login(@RequestBody LoginRequest loginrequest){
//		Object result;
////		try {
//			Authentication authentication = authenticationManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(
//	                		loginrequest.getUserName(),
//	                		loginrequest.getPassword()//password mã hóa rồi
//	                )					
//				);			
//			//Nếu không xảy exception là thông tin ok
//			//Set thông tin authentication vào Security context
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//			
//			//Trả jwt cho client
//			String jwt = jwtTokenProvider.generateToken((MyUserDetails) authentication.getPrincipal());
//			
//			MyUserDetails userDetails = (MyUserDetails)  authentication.getPrincipal();
//			//set reponse về cho client
//			 result= new LoginRespone(
//					userDetails.getUsername(),
//					jwt,
//					userDetails.getAddress(),
//					userDetails.getFullName(),
//					userDetails.getAuthorities().stream().findFirst().get().toString()
//					); 
////		}catch(BadCredentialsException e) {
//////			result = new MessageResponse("Username or Password is incorrect!");
////			return ResponseEntity.ok().body(HttpStatus.UNAUTHORIZED);
////		}
//		
//		return ResponseEntity.ok().body(result);
//	}
//	
//}
