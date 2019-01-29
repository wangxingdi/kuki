package com.developwiki.kuki.basic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体类
 * @author wangxd
 */
@Entity
@Table(name="kuki_basic_role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@Id
	@Column(name="role_id")
	private String roleId;
	
	/**
	 * 角色名称
	 */
	@Column(name="role_name")
	private String roleName;
	
	/**
	 * 角色描述
	 */
	@Column(name="role_desc")
	private String roleDesc;
	
	/**
	 * 状态
	 */
	@Column(name="status")
	private String status;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
