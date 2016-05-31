/**
 * 
 */
package com.lujing.website.model;

import java.io.Serializable;


/**
 * @author mays
 *
 */
public class BaseCond implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer start;
	private Integer limit;

	public Integer getLimit() {
		if(limit==null){
			limit = Pager.DEFAULT_LIMIT;
		}
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		if(start==null){
			return Pager.DEFAULT_START;
		}
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
	
	
}
