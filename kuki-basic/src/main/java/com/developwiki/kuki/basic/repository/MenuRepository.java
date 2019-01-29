package com.developwiki.kuki.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.developwiki.kuki.basic.entity.Menu;

/**
 * 菜单表操作接口
 * @author wangxd
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, String>{

	/**
	 * 根据角色id集合查询菜单集合
	 * @param roleIdList
	 * @return List<Menu>
	 */
	@Query("select m from Menu m, RoleMenu rm where m.menuId = rm.menuId and rm.roleId in (?1)")
	List<Menu> findByRoleIdList(List<String> roleIdList);

}
