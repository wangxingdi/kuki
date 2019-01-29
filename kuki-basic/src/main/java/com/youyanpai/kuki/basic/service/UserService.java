package com.youyanpai.kuki.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youyanpai.kuki.basic.entity.User;
import com.youyanpai.kuki.basic.repository.UserRepository;

/**
 * 用户服务类
 * @author wangxd
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * 根据用户名查询用户
	 */
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
