package com.jp.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jp.poc.service.InterfaceWithoutImpl;
import com.jp.poc.service.UserService;
import com.jp.poc.service.impl.AbstractUserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//We can not autowire Abstract class. Abstract class can't be initialized
//	@Autowired
//	private AbstractUserServiceImpl abstractUserServiceImpl;
	
//	We can not autowire interface without implementationFs
//	@Autowired
//	private InterfaceWithoutImpl interfaceWithoutImpl;

	@GetMapping(path = "users/{id}")
	public String getUserName(@PathVariable("id") String id) {
//		abstractUserServiceImpl.getStatus();
		return userService.getUserName(id);
	}
}
