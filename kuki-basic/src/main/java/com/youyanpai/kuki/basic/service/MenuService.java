package com.youyanpai.kuki.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youyanpai.kuki.basic.entity.Menu;
import com.youyanpai.kuki.basic.repository.MenuRepository;

/**
 * 菜单服务类
 * @author wangxd
 */
@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	/**
	 * 根据角色id集合查询菜单集合
	 */
	public List<Menu> findByRoleIdList(List<String> roleIdList) {
		return menuRepository.findByRoleIdList(roleIdList);
	}

}
