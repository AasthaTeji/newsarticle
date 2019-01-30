package com.cts.newsarticle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.newsarticle.bean.Article;

public interface NewsRepository extends JpaRepository<Article, Integer> {
	
	public Article getArticleByTitle(String title);

}
