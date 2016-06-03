package com.lujing.website.model;

public class NewsModel extends News{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//第几页
	private Integer pageNum;
	//总页数
	private Integer pageCount;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
}
