package com.developwiki.kuki.basic.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class RoleUser {
	
	@Id
	@Column(name="role_id")
	private String roleId;
	
	@Id
	@Column(name="user_id")
	private String userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
