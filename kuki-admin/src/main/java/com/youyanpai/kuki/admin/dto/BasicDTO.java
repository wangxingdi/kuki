package com.youyanpai.kuki.admin.dto;

/**
 * 基础数据传输类
 * @author wangxd
 */
public class BasicDTO {
	
	/**
	 * 页索引
	 */
	private Integer pageIndex;
	
	/**
	 * 页大小
	 */
	private Integer pageSize;
	
	/**
	 * 排序字段
	 */
	private String sortName;
	
	/**
	 * 排序方向
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

	@Override
	public String toString() {
		return "BasicDTO [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", sortName=" + sortName
				+ ", sortDirection=" + sortDirection + "]";
	}

}
