package com.developwiki.kuki.basic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name="password")
	private String password;
	
	/**
	 * 手机号码
	 */
	@Column(name="mobile")
	private String mobile;
	
	/**
	 * 手机号码
	 */
	@Column(name="telephone")
	private String telephone;
	
	/**
	 * 电子邮箱
	 */
	@Column(name="email")
	private String email;
	
	/**
	 * 真实姓名
	 */
	@Column(name="real_name")
	private String realName;
	
	/**
	 * 状态:1-正常;0-锁定
	 */
	@Column(name="status")
	private String status;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	

}
