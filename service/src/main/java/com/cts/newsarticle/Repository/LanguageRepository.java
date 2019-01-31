package com.cts.newsarticle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.newsarticle.bean.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

	
}
