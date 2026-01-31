package com.monyflow.services;

import org.springframework.stereotype.Service;

import com.monyflow.dto.RegisterRequest;
import com.monyflow.entity.User;
import com.monyflow.repository.UserRepository;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	
	//constructor injection
	public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public User register(RegisterRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email Alredy register");
		}
		
		  User user = new User();
		    user.setName(request.getName());
		    user.setEmail(request.getEmail());
		    user.setPassword(request.getPassword());
		return userRepository.save(user);
	}
}
