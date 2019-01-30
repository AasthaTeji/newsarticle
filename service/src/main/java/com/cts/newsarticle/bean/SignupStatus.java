package com.cts.newsarticle.bean;

public class SignupStatus {
	
	private boolean signupStatus;
	private boolean emailExist;
	
	
	public SignupStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isSignupStatus() {
		return signupStatus;
	}
	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}
	public boolean isEmailExist() {
		return emailExist;
	}
	public void setEmailExist(boolean emailExist) {
		this.emailExist = emailExist;
	}
	@Override
	public String toString() {
		return "SignupStatus [signupStatus=" + signupStatus + ", emailExist=" + emailExist + "]";
	}
	
	
}
