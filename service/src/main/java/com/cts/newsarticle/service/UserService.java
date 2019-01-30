package com.cts.newsarticle.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.newsarticle.AuthenticationStatus;
import com.cts.newsarticle.bean.SignupStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.controller.UserController;
import com.cts.newsarticle.dao.UserDao;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserDao userDao;
	
	
	public SignupStatus signup(User user){
		LOGGER.info("Start");
		LOGGER.debug("User :{}", user);
		SignupStatus status = new SignupStatus();
		status.setEmailExist(false);

		User existingUser = userDao.getUserByEmail(user.getEmail());
		LOGGER.debug("User from database :{}", existingUser);
		if (existingUser != null) {
			LOGGER.info("user exists");
			status.setEmailExist(true);
		}
		if (!status.isEmailExist()) {

			userDao.save(user);
			status.setSignupStatus(true);
			LOGGER.info("Signup successful");
		}
		LOGGER.info("end");
		return status;
	}
	
	
	@Transactional
	public AuthenticationStatus authenticationStatus(User user){
		
		String email= user.getEmail();
		User existingUser= userDao.getUserByEmail(email);
		
		String password = user.getPassword();
		String existingPassword =existingUser.getPassword();
		
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthentication(false);
		
		if( existingUser != null){
			
			if(password.equals(existingPassword)){
				status.setAuthentication(true);
				status.setUser(user);
			}
		}
		
		return status;
	}
}
		
		
		
	
