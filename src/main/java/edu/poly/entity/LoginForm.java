package edu.poly.entity;

public class LoginForm {
	private String id;
	private String password;
	private boolean remember;
	
	public LoginForm() {
	}
	
	public LoginForm(String id, String password, boolean remember) {
		this.id = id;
		this.password = password;
		this.remember = remember;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	
}
