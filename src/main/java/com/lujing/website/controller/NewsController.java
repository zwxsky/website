package com.lujing.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lujing.website.model.News;
import com.lujing.website.model.NewsCond;
import com.lujing.website.model.NewsModel;
import com.lujing.website.model.Pager;
import com.lujing.website.service.NewsService;
import com.lujing.website.utils.ServiceException;

@Controller
@RequestMapping("/news")
public class NewsController extends BaseController{
	
	@Autowired(required = true)
	public NewsService newsService;
	
	@RequestMapping(value="/page/{num}",method=RequestMethod.GET)
	public String getPageNews(HttpServletRequest request,HttpServletResponse response,ModelMap model,
			@PathVariable("num") Integer num){
		List<NewsModel> newsList =newsService.pagerModel(num, "id");
		Integer count = newsService.countByCond(new NewsCond() );
		model.put("newsList", newsList);
		int pageCount; 
		if(count%Pager.DEFAULT_LIMIT !=0){
			pageCount =count/Pager.DEFAULT_LIMIT+1;
		}else{
			pageCount =count/Pager.DEFAULT_LIMIT;
		}
		model.put("newsList", newsList);
		model.put("pageCount", pageCount);
		model.put("pageNum", num);
		return "news/dashboard";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getNewsList(HttpServletRequest request,HttpServletResponse response,ModelMap model
			){
		List<NewsModel> newsList =newsService.pagerModel(1, "id");
		Integer count = newsService.countByCond(new NewsCond() );
		model.put("newsList", newsList);
		int pageCount; 
		if(count%Pager.DEFAULT_LIMIT !=0){
			pageCount =count/Pager.DEFAULT_LIMIT+1;
		}else{
			pageCount =count/Pager.DEFAULT_LIMIT;
		}
		model.put("newsList", newsList);
		model.put("pageCount", pageCount);
		model.put("pageNum", 1);
		return "news/dashboard";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getNews(HttpServletRequest request,HttpServletResponse response,ModelMap model,
			@PathVariable("id") Long id){
		News news;
		try {
			news = newsService.queryModel(id);
			model.put("news", news);
			return "news/detail";
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

}
