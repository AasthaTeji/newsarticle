package com.cts.newsarticle.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.newsarticle.ArticleStatus;
import com.cts.newsarticle.Repository.NewsRepository;
import com.cts.newsarticle.Repository.UserRepository;
import com.cts.newsarticle.bean.Article;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.controller.UserController;
import com.cts.newsarticle.dao.UserDao;

@Service
public class NewsService {
	
private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private UserRepository userRepository;
	
	public ArticleStatus saveArticle(Article article)
	{
	    
		ArticleStatus articleStatus=new ArticleStatus();
		articleStatus.setArticleExists(false);
		articleStatus.setArticleSaved(false);
		articleStatus.setArticleSetFav(false);
		
		Article actualArticle = newsRepository.getArticleByTitle(article.getTitle());
		
		if(actualArticle != null){
			articleStatus.setArticleExists(true);
			
			LOGGER.info("article exists");
		}
		
		
		if (! articleStatus.isArticleExists()) {
			newsRepository.save(article);
			LOGGER.info("article saved successfully");
			User user=userRepository.findUserByEmail(article.getEmail());
			user.getArticles().add(article);
			userRepository.save(user);
			articleStatus.setArticleSaved(true);
			articleStatus.setArticleSetFav(false);
		}
		
		else{
			
			
				User user=userRepository.findUserByEmail(article.getEmail());
				user.getArticles().add(actualArticle);
				userRepository.save(user);
				articleStatus.setArticleSaved(false);
				articleStatus.setArticleSetFav(true);
			
		}
		return articleStatus;		
	}

	

}
