package com.abc.film.domain;

public class Buy extends ValueObject{
	
	private String userId;/*用户名*/
	private String userPaw;/*密码*/
	private String userAnser;/*答案*/

	private String userAnser2;/**/

	public String getUserId() {
		return userId;
	}

	public String setUserId(String userId) {
		return this.userId = userId;
	}

	public String getUserPaw() {
		return userPaw;
	}

	public void setUserPaw(String userPaw) {
		this.userPaw = userPaw;
	}

	public String getUserAnser() {
		return userAnser;
	}

	public void setUserAnser(String userAnser) {
		this.userAnser = userAnser;
	}

	public String getUserAnser2() {
		return userAnser2;
	}

	public void setUserAnser2(String userAnser2) {
		this.userAnser2 = userAnser2;
	}
	
	
	
}
