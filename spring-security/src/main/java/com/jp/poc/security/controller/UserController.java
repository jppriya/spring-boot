package com.jp.poc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(value="/user")
	public String getUserStatus() {
		return "SECURE";
	}

	
	@GetMapping("/unsecure/status")
	public String getStatus() {
		return "NOT SECURE";
	}
}
