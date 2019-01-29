package com.youyanpai.kuki.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youyanpai.kuki.basic.entity.User;

/**
 * �û��������
 * @author wangxd
 */
public interface UserRepository extends JpaRepository<User, String>{

	/**
	 * �����û�����ѯ�û�
	 * @param username
	 * @return User
	 * @author wangxd
	 */
	public User findByUsername(String username);

}
