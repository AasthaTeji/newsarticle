package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public AuthenticationStatus login(@RequestBody User user) {
		LOGGER.info("START : Inside addUser() method of UserController");
		LOGGER.debug("User Object :  {}", user);

		return userService.authenticationStatus(user);
	}
	
	@GetMapping("/search/{name}")
	public User searchAnalyst(@PathVariable String name) {
		LOGGER.info("START ");
		LOGGER.debug("name :  {}", name);
		User user = userService.search(name);
		return user;
	}
	
}
