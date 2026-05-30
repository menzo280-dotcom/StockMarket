package com.enzomartins.stockmarket.resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzomartins.stockmarket.dto.LoginRequestDTO;
import com.enzomartins.stockmarket.dto.LoginResponseDTO;
import com.enzomartins.stockmarket.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthResource {
	
	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto){
		LoginResponseDTO obj = service.login(dto);
		return ResponseEntity.ok(obj);
	}

}
