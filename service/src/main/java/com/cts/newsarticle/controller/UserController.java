package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.AuthenticationStatus;
import com.cts.newsarticle.bean.SignupStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.service.UserService;

@RestController
public class UserController extends ExceptionController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/signup")
	public SignupStatus signup(@RequestBody User user){
		LOGGER.info("Start");
		return userService.signup(user);
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationStatus> login(@RequestBody User user){
		LOGGER.info("Start");
		AuthenticationStatus status = userService.authenticationStatus(user);
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
	}
	

	
}
