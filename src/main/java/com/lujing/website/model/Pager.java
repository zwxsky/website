
package com.lujing.website.model;


import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.google.common.base.Strings;

/**
 * @author Mays (x03570227@gmail.com)
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class Pager<E> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	public static final String DIR_DESC="desc";
//	public static final String DIR_ASC="asc";
	
	public final static int DEFAULT_START = 0;//默认起始记录位置
	public final static int DEFAULT_LIMIT = 2;//默认页面大小
	
	private Integer totals;// 总行数
	private Integer start;// 页起始记录
	private Integer limit;//页面大小（每页最大显示的数据条数)
	private String sort;//排序字段名称
	private String dir;//排序规则［asc/desc］
	private List<E> records;
	
	private String sortColumn;
	
	public Integer getTotals() {
		return totals;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	public Integer getStart() {
		if(start==null){
			start=DEFAULT_START;
		}
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		if(limit==null){
			limit = DEFAULT_LIMIT;
		}
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		
		if (Strings.isNullOrEmpty(dir)) {
			return DirEnum.DESC.name();
		}

		for (DirEnum d : DirEnum.values()) {
			if (dir.equalsIgnoreCase(d.name())) {
				return dir;
			}
		}

		return DirEnum.DESC.name();
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public List<E> getRecords() {
		return records;
	}
	public void setRecords(List<E> records) {
		this.records = records;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	

}
