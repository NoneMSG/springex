package com.jx372.springex.controller;

public class UserVo {
	private String email;
	private String password;
	
	@Override
	public String toString() {
		return "UserVo [email=" + email + ", password=" + password + "]";
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
}
