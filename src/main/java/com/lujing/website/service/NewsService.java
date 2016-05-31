package com.lujing.website.service;

import java.util.List;

import com.lujing.website.model.News;
import com.lujing.website.utils.ServiceException;

public interface NewsService {
	
	public List<News> pagerModel(Integer pagerNum,String sort);

	public News queryModel(Long id) throws ServiceException;

}
