package com.cts.newsarticle;

import com.cts.newsarticle.bean.User;

public class AuthenticationStatus {

	private boolean authentication;
	private User user;
	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isAuthentication() {
		return authentication;
	}
	public void setAuthentication(boolean authentication) {
		this.authentication = authentication;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
