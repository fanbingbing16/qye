package com.abc.film.domain;

public class User2 extends ValueObject{
	
	private String userName;
	private String userPassword;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String string) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}
	
}
