package com.developwiki.kuki.basic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 参数字典实体类
 * @author wangxd
 */
@Entity
@Table(name="kuki_basic_param")
public class Param implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Id
	@Column(name="param_id")
	private String paramId;
	
	/**
	 * 模块组
	 */
	@Column(name="module")
	private String module;
	
	/**
	 * 参数名称
	 */
	@Column(name="param_name")
	private String paramName;
	
	/**
	 * 参数值
	 */
	@Column(name="param_value")
	private String paramValue;

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
}
