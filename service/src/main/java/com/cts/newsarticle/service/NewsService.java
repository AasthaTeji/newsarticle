package com.cts.newsarticle.service;

import java.util.List;

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

@Service
public class NewsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private UserRepository userRepository;

	public ArticleStatus saveArticle(Article article) {

		ArticleStatus articleStatus = new ArticleStatus();
		articleStatus.setArticleExists(false);
		articleStatus.setArticleSaved(false);
		articleStatus.setArticleSetFav(false);

		Article actualArticle = newsRepository.getArticleByTitle(article.getTitle());

		if (actualArticle != null) {
			articleStatus.setArticleExists(true);
			LOGGER.info("article exists");
		}

		if (!articleStatus.isArticleExists()) {
			newsRepository.save(article);
			LOGGER.info("article saved successfully");
			User user = userRepository.findUserByEmail(article.getEmail());
			user.getArticles().add(article);
			userRepository.save(user);
			articleStatus.setArticleSaved(true);
			articleStatus.setArticleSetFav(false);
		} else {

			User user = userRepository.findUserByEmail(article.getEmail());
			user.getArticles().add(actualArticle);
			userRepository.save(user);
			articleStatus.setArticleSaved(false);
			articleStatus.setArticleSetFav(true);

		}
		return articleStatus;
	}
	
	public User listFavArticles(String email){
		LOGGER.info("start");
		LOGGER.info("Email id: {}",email);
		User user = userRepository.findUserByEmail(email);
		LOGGER.info("found fav articles");
		return user;
	}

	public User deleteFavArticles(Article article){
		LOGGER.info("start");
		
		//User user =new User();
		User actualUser = userRepository.findUserByEmail(article.getEmail());
		LOGGER.debug("Actual User from Database {}", actualUser );
		List<Article> articles = actualUser.getArticles();
//		Article article =newsRepository.getArticleByTitle(title);
		for(int i=0;i< actualUser.getArticles().size();i++){
			LOGGER.debug("Title of article {}", articles.get(i).getTitle() );
			if(actualUser.getArticles().get(i).getTitle().equals(article.getTitle())){
				articles.remove(i);
				break;
			}
		
		}
		userRepository.save(actualUser);
		LOGGER.info("deleted fav articles");
		return actualUser;
	}

}
