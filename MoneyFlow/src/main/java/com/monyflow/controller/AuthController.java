package com.monyflow.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monyflow.dto.RegisterRequest;
import com.monyflow.entity.User;
import com.monyflow.services.AuthService;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthService authService;
	
	// constructor injection
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public User register(@RequestBody RegisterRequest request) {
		return authService.register(request);
		
	}
}
