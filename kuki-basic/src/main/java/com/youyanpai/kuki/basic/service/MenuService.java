package com.youyanpai.kuki.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youyanpai.kuki.basic.entity.Menu;
import com.youyanpai.kuki.basic.repository.MenuRepository;

/**
 * �˵�������
 * @author wangxd
 */
@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	/**
	 * ���ݽ�ɫid���ϲ�ѯ�˵�����
	 */
	public List<Menu> findByRoleIdList(List<String> roleIdList) {
		return menuRepository.findByRoleIdList(roleIdList);
	}

}
