package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.bean.Article;
import com.cts.newsarticle.service.NewsService;

@RestController
public class NewsController {

private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private NewsService newsService;
	
	@PostMapping("/save")
	public Article saveArticle(@RequestBody Article article){
		newsService.saveArticle(article);
		return article;
		
	}
}
