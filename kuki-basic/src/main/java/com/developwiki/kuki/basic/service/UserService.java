package com.developwiki.kuki.basic.service;

import com.developwiki.kuki.basic.entity.User;
import com.developwiki.kuki.basic.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
