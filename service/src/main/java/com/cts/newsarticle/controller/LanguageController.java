package com.cts.newsarticle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.bean.Language;
import com.cts.newsarticle.service.LanguageService;


@RestController
public class LanguageController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
	
	@Autowired
	private LanguageService languageService;
	
//	public void setLanguageService(LanguageService languageService ){
//		this.languageService=languageService;
//	}
	
	@GetMapping("/list")
	public List<Language> fetchAllLanguage(){
		LOGGER.info("START");
		return languageService.fetchLanguages();
	}
	

}
