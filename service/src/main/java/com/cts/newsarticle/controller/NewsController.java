package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.ArticleStatus;
import com.cts.newsarticle.bean.Article;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.service.NewsService;

@RestController
@RequestMapping("/rest")
public class NewsController {

private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private NewsService newsService;
	
	@PostMapping("/save")
	public ArticleStatus saveArticle(@RequestBody Article article){
//		newsService.saveArticle(article);
		return newsService.saveArticle(article);
		
	}
	
	@GetMapping("/show/{email}")
	public User listFavourite(@PathVariable String email){
		User user = newsService.listFavArticles(email);
		return user;
		
	}
	
	@PostMapping("/delete")
	public User deleteFavourite(@RequestBody Article article){
		User user = newsService.deleteFavArticles(article);
		LOGGER.debug("user {}",user);
		return user;
		
	}
}
