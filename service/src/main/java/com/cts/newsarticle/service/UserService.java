package com.cts.newsarticle.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.newsarticle.AuthenticationStatus;
import com.cts.newsarticle.Repository.UserRepository;
import com.cts.newsarticle.bean.SignupStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.controller.UserController;
import com.cts.newsarticle.dao.UserDao;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public SignupStatus signup(User user){
		LOGGER.info("Start");
		LOGGER.debug("User :{}", user);
		SignupStatus status = new SignupStatus();
		status.setEmailExist(false);

		User existingUser = userRepository.findUserByEmail(user.getEmail());
		LOGGER.debug("User from database :{}", existingUser);
		if (existingUser != null) {
			LOGGER.info("user exists");
			status.setEmailExist(true);
		}
		if (!status.isEmailExist()) {

			userRepository.save(user);
			status.setSignupStatus(true);
			LOGGER.info("Signup successful");
		}
		LOGGER.info("end");
		return status;
	}
	
	
	@Transactional
	public AuthenticationStatus authenticationStatus(User user){
		LOGGER.info("Start");
		String email= user.getEmail();
		User existingUser= userRepository.findUserByEmail(user.getEmail());
		
		String password = user.getPassword();
		String existingPassword =existingUser.getPassword();
		
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthentication(false);
		
		if( existingUser != null){
			
			if(password.equals(existingPassword)){
				status.setAuthentication(true);
				status.setUser(existingUser);
			}
		}
		LOGGER.info("end");
		return status;
	}
	
	
	
}
		
		
		
	
