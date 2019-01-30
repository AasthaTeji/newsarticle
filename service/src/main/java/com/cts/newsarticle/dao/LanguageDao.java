package com.cts.newsarticle.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.newsarticle.bean.Language;
import com.cts.newsarticle.bean.User;

@Component
public class LanguageDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}
	
	public List<Language> getAllLanguages() {
		//Language language = new Language();
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Language> languages = (List<Language>) session.createQuery("from Language").list();
		session.close();
		return languages;
	}

}
