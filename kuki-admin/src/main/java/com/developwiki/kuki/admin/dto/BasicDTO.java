package com.developwiki.kuki.admin.dto;

public class BasicDTO {
	
	/**
	 * ҳ����
	 */
	private int pageIndex;
	
	/**
	 * ҳ��С
	 */
	private int pageSize;
	
	/**
	 * �����ֶ�
	 */
	private String sortName;
	
	/**
	 * ������
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
