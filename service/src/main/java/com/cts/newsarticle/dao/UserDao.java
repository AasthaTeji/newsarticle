package com.cts.newsarticle.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.controller.UserController;

@Component
public class UserDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}
	
	@Transactional
	public User getUserByEmail(String email) {
		LOGGER.info("start");
		User user = null;
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createQuery("from User u where u.email = :email")
				.setParameter("email", email).list();
		if (users.size() > 0) {
			LOGGER.info("inside check user by email");
			user = users.get(0);
		}
		session.close();
		return user;
	}
	
	@Transactional
	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();		
	}
	
	
}
