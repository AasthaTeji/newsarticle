package com.cts.newsarticle;

import com.cts.newsarticle.bean.User;

public class AuthenticationStatus {

	private boolean authentication;
	private User user;
	
	
	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AuthenticationStatus(boolean authentication) {
		super();
		this.authentication = authentication;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authentication ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthenticationStatus other = (AuthenticationStatus) obj;
		if (authentication != other.authentication)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	


}
