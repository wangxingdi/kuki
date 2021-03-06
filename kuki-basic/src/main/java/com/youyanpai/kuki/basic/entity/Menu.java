package com.youyanpai.kuki.basic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * èåå®ä½ç±?
 * @author wangxd
 */
@Entity
@Table(name="kuki_basic_menu")
public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ä¸»é®ID
	 */
	@Id
	@Column(name="menu_id")
	private String menuId;
	
	/**
	 * ç¶çº§èåID
	 */
	@Column(name="parent_id")
	private String parentId;
	
	/**
	 * èåä»£ç 
	 */
	@Column(name="menu_code")
	private String menuCode;
	
	/**
	 * èååç§°
	 */
	@Column(name="menu_name")
	private String menuName;
	
	/**
	 * èåé¡ºåº
	 */
	@Column(name="sequence")
	private Integer sequence;
	
	/**
	 * èåç¶æ??(1-å¯ç¨;0-åç¨)
	 */
	@Column(name="status")
	private String status;
	
	@Transient
	private List<Menu> children;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	

}
