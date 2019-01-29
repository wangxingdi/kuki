package com.youyanpai.kuki.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youyanpai.kuki.basic.entity.User;

/**
 * 用户表操作类
 * @author wangxd
 */
public interface UserRepository extends JpaRepository<User, String>{

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return User
	 * @author wangxd
	 */
	public User findByUsername(String username);

}
