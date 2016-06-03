package com.lujing.website.service;

import java.util.List;

import com.lujing.website.model.News;
import com.lujing.website.model.NewsCond;
import com.lujing.website.model.NewsModel;
import com.lujing.website.utils.ServiceException;

public interface NewsService {
	
	public List<NewsModel> pagerModel(Integer pagerNum,String sort);

	public News queryModel(Long id) throws ServiceException;

	public Integer countByCond(NewsCond newsCond);

}
