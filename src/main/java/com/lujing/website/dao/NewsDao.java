package com.lujing.website.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lujing.website.model.News;
import com.lujing.website.model.NewsCond;
import com.lujing.website.model.NewsModel;
import com.lujing.website.model.Pager;

public interface NewsDao {
	
	public News queryModel(Long id);

//	public List<News> queryByPager(Pager<News> pager);

	public List<NewsModel> pagerModel(@Param("pager")Pager<News> pager);
	
	public Integer countByCond(@Param("cond")NewsCond cond);
}
