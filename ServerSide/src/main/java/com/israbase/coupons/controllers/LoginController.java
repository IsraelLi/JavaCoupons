package com.israbase.coupons.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israbase.coupons.entities.User;
import com.israbase.coupons.helpers.exceptions.UserNotFoundException;
import com.israbase.coupons.services.api.SystemService;

@RestController
public class LoginController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/login")
	public ResponseEntity<User> login(HttpServletRequest request) throws UserNotFoundException {
		return ResponseEntity.ok().body(systemService.login(request));			
	}
	
	@GetMapping("/logoff")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		return ResponseEntity.ok().body(systemService.logout(request));
	}
}
