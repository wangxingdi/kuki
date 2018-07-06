package com.developwiki.kuki.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.developwiki.kuki.basic.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

	@Query("select r from Role r, RoleUser ru where r.roleId = ru.roleId and ru.userId = ?1 ")
	List<Role> findByUserId(String userId);

}
