package com.developwiki.kuki.basic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户实体类
 * @author wangxd
 */
@Entity
@Table(name="kuki_basic_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@Id
	@Column(name="user_id")
	private String userId;
	
	/**
	 * 用户名
	 */
	@Column(name="username")
	private String username;
	
	/**
	 * 密码
	 */
	@Column(name="pwd")
	private String pwd;
	
	/**
	 * 移动电话
	 */
	@Column(name="mobile")
	private String mobile;
	
	/**
	 * 固话
	 */
	@Column(name="telephone")
	private String telephone;
	
	/**
	 * 电子邮件
	 */
	@Column(name="email")
	private String email;
	
	/**
	 * 真实姓名
	 */
	@Column(name="real_name")
	private String realName;
	
	/**
	 * 状态
	 */
	@Column(name="status")
	private String status;
	
	@Transient
	private List<Role> roleList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
