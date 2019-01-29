package com.developwiki.kuki.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developwiki.kuki.basic.entity.Role;
import com.developwiki.kuki.basic.repository.RoleRepository;

/**
 * ��ɫ������
 * @author wangxd
 */
@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * �����û�id��ѯ��ɫ����
	 */
	public List<Role> findByUserId(String userId) {
		return roleRepository.findByUserId(userId);
	}

}
