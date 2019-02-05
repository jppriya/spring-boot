package com.jp.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jp.poc.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "users/{id}")
	public String getUserName(@PathVariable("id") String id) {
		return userService.getUserName(id);
	}
}
