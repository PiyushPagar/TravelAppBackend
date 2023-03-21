package com.example.LuggagueTransformation.dto;


import java.util.List;


import javax.persistence.Column;

import org.springframework.http.HttpStatus;

public class UserInfoResponse {
	private Long id;
	private String email;
	private String name;
	private String role;
	private String jwtToken;
	private String mobileNo;
	private boolean isNew;
	
	
	
	
	public UserInfoResponse(Long id, String email, String name, String role, String jwtToken, String mobileNo,
			boolean isNew) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.role = role;
		this.jwtToken = jwtToken;
		this.mobileNo = mobileNo;
		this.isNew = isNew;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	



}