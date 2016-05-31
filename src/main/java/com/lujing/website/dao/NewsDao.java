package com.lujing.website.dao;

import java.util.List;

import com.lujing.website.model.News;
import com.lujing.website.model.Pager;

public interface NewsDao {
	
	public News queryModel(Long id);

//	public List<News> queryByPager(Pager<News> pager);

	public List<News> pagerModel(Pager<News> pager);
	
}
