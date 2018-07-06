package com.developwiki.kuki.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.developwiki.kuki.basic.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String>{

	@Query("select m from Menu m, RoleMenu rm where m.menuId = rm.menuId and rm.roleId in (?1)")
	List<Menu> findByRoleIdList(List<String> roleIdList);

}
