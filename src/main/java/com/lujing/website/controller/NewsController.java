package com.lujing.website.controller;

import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lujing.website.model.DirEnum;
import com.lujing.website.model.News;
import com.lujing.website.service.NewsService;
import com.lujing.website.utils.ServiceException;

@Controller
@RequestMapping("/")
public class NewsController extends BaseController{
	
	@Autowired(required = true)
	public NewsService newsService;
	
	@RequestMapping(value="/{num}",method=RequestMethod.GET)
	public String getNews(HttpRequest request,HttpResponse response,ModelMap model,
			@PathVariable("num") Integer num){
		List<News> newsList =newsService.pagerModel(num, DirEnum.ASC.name());
		model.put("newsList", newsList);
		return "news/dashboard";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getNews(HttpRequest request,HttpResponse response,ModelMap model,
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
