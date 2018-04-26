package com.senla.training.model;

public class User {
	private Long ID;
	private String login;
	private String password;
	
	
	public User(Long id, String login,String password){
		this.ID = id;
		this.login = login;
		this.password = password;
	}
	
	public void setUserID(Long id) {
		this.ID = id;
	}
	public Long getUserID() {
		return ID;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + ID + ", " + "login= " + login + "password= " + password +"]";
	}
}
