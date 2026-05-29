package com.enzomartins.stockmarket.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzomartins.stockmarket.dto.LoginRequestDTO;
import com.enzomartins.stockmarket.entities.User;
import com.enzomartins.stockmarket.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthResource {
	
	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginRequestDTO dto){
		User obj = service.login(dto);
		return ResponseEntity.ok(obj);
	}

}
