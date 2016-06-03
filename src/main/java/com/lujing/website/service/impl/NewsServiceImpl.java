package com.lujing.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.lujing.website.dao.NewsDao;
import com.lujing.website.model.News;
import com.lujing.website.model.NewsCond;
import com.lujing.website.model.NewsModel;
import com.lujing.website.model.Pager;
import com.lujing.website.service.NewsService;
import com.lujing.website.utils.LongUtils;
import com.lujing.website.utils.ServiceException;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;
	
	public List<NewsModel> pagerModel(Integer pagerNum,String sort){
		
		if(pagerNum<1){
			return null;
		}
		
		Pager<News> pager  = new Pager<News>();
		pager.setStart((pagerNum-1)*pager.getLimit());
		if(!Strings.isNullOrEmpty(sort)){
			pager.setSort(sort);
		}
		List<NewsModel> newsList  =newsDao.pagerModel(pager);
		
		return newsList;
	}

	public News queryModel(Long id) throws ServiceException {
		if(LongUtils.isEmpty(id)){
			throw new ServiceException("");
		}
		return newsDao.queryModel(id);
	}


	public Integer countByCond(NewsCond newsCond) {
		return newsDao.countByCond(newsCond);
	}

	public static void main(String[] args) {
		System.out.println(5 %3);
		System.out.println(5/3);
	}
}
