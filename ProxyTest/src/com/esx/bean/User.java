package com.esx.bean;

public class User {
    private String username;
    private String userpassword;
    private Agen gender;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public Agen getGender() {
		return gender;
	}
	public void setGender(Agen gender) {
		this.gender = gender;
	}
	public User(String username, String userpassword, Agen gender) {
		this.username = username;
		this.userpassword = userpassword;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", userpassword=" + userpassword + ", gender=" + gender + "]";
	}
    
}
