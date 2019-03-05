package com.jp.poc.service.impl;

import org.springframework.stereotype.Component;

import com.jp.poc.service.UserService;

@Component
public abstract class AbstractUserServiceImpl implements UserService {
	
	public String getStatus() {
		return "SUCCESS";
	}

}
