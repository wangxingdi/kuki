package com.youyanpai.kuki.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.youyanpai.kuki.basic.entity.Role;

/**
 * 角色表操作接口
 * @author wangxd
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

	/**
	 * 根据用户id查询角色集合
	 * @param userId
	 * @return List<Role>
	 * @author wangxd
	 */
	@Query("select r from Role r, RoleUser ru where r.roleId = ru.roleId and ru.userId = ?1 ")
	List<Role> findByUserId(String userId);

}
