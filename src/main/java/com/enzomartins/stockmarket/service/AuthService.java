package com.enzomartins.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.enzomartins.stockmarket.dto.LoginRequestDTO;
import com.enzomartins.stockmarket.dto.LoginResponseDTO;
import com.enzomartins.stockmarket.entities.User;
import com.enzomartins.stockmarket.repository.UserRepository;
import com.enzomartins.stockmarket.service.exception.ResourceNotFoundException;

@Service
public class AuthService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JwtService jwtService;
	
	public LoginResponseDTO login(LoginRequestDTO dto){
		User user = repository.findByEmail(dto.getEmail())
		        .orElseThrow(() -> new ResourceNotFoundException(dto.getEmail()));
		if (!user.getPassword().equals(dto.getPassword())) {
		    throw new IllegalArgumentException("Invalid password");
		}
		String token = jwtService.generateToken(user);
		return new LoginResponseDTO(token);
	}
	
}
