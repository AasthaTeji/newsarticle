package com.cts.newsarticle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.newsarticle.bean.Language;
import com.cts.newsarticle.controller.UserController;
import com.cts.newsarticle.dao.LanguageDao;

@Service
public class LanguageService {
	
private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
@Autowired
	private LanguageDao languageDao;
	
	@Transactional
	public List<Language> getLanguages(){
		LOGGER.info("start");
		List<Language> allLanguages = languageDao.getAllLanguages();
		return allLanguages;
	}

}
