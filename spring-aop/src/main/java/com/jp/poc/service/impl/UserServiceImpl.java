package com.jp.poc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jp.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private Map<String, String> getUsers() {
		Map<String, String> user = new HashMap<>();
		user.put("1", "Jayapriya");
		user.put("2", "Priya");
		return user;
	}

	@Override
	public String getUserName(String id) {
		return this.getUsers().get(id);
	}

}
