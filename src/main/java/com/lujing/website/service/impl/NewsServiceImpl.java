package com.lujing.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.lujing.website.dao.NewsDao;
import com.lujing.website.model.News;
import com.lujing.website.model.Pager;
import com.lujing.website.service.NewsService;
import com.lujing.website.utils.LongUtils;
import com.lujing.website.utils.ServiceException;

public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;
	
	public List<News> pagerModel(Integer pagerNum,String sort){
		Pager<News> pager  = new Pager<News>();
		pager.setStart((pagerNum-1)*pager.getLimit());
		if(!Strings.isNullOrEmpty(sort)){
			pager.setSort(sort);
		}
		List<News> newsList  =newsDao.pagerModel(pager);
		return newsList;
	}

	public News queryModel(Long id) throws ServiceException {
		if(LongUtils.isEmpty(id)){
			throw new ServiceException("");
		}
		return newsDao.queryModel(id);
	}


}
