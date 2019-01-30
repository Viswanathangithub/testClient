package com.citi.testclient.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection ="userDetails")
public class UserDetails {

	@Field("userName")
	private String userName;
	@Field("password")
	private String password;
	@Field("userId")
	private String userId;
	@Field("role")
	private String role;
	@Field("ip")
	private String[] ip;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String[] getIp() {
		return ip;
	}
	public void setIp(String[] ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", password=" + password + ", userId=" + userId + ", role=" + role
				+ ", ip=" + Arrays.toString(ip) + "]";
	}
	
}
