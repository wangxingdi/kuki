package com.developwiki.kuki.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developwiki.kuki.basic.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByUsername(String username);

}
