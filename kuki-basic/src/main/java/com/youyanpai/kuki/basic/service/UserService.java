package com.youyanpai.kuki.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youyanpai.kuki.basic.entity.User;
import com.youyanpai.kuki.basic.repository.UserRepository;

/**
 * �û�������
 * @author wangxd
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * �����û�����ѯ�û�
	 */
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
