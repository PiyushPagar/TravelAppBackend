package com.example.LuggagueTransformation.dto;

public class UpdateUser {
	
	
	
    private String email;
	
	private String name;
	
	private String mobileNo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UpdateUser(String email, String name, String mobileNo) {
		super();
		this.email = email;
		this.name = name;
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
