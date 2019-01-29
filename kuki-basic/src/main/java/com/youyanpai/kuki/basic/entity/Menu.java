package com.youyanpai.kuki.basic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 菜单实体�?
 * @author wangxd
 */
@Entity
@Table(name="kuki_basic_menu")
public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 */
	@Id
	@Column(name="menu_id")
	private String menuId;
	
	/**
	 * 父级菜单ID
	 */
	@Column(name="parent_id")
	private String parentId;
	
	/**
	 * 菜单代码
	 */
	@Column(name="menu_code")
	private String menuCode;
	
	/**
	 * 菜单名称
	 */
	@Column(name="menu_name")
	private String menuName;
	
	/**
	 * 菜单顺序
	 */
	@Column(name="sequence")
	private Integer sequence;
	
	/**
	 * 菜单状�??(1-启用;0-停用)
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
