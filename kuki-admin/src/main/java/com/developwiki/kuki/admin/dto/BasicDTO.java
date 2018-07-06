package com.developwiki.kuki.admin.dto;

public class BasicDTO {
	
	/**
	 * Ò³Ë÷Òý
	 */
	private int pageIndex;
	
	/**
	 * Ò³´óÐ¡
	 */
	private int pageSize;
	
	/**
	 * ÅÅÐò×Ö¶Î
	 */
	private String sortName;
	
	/**
	 * ÅÅÐò·½Ïò
	 */
	private String sortDirection;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

}
