package com.hj.web.model;

public class SysUser {
	private int id;
	private String username;
	private String password;
	
	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SysUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
