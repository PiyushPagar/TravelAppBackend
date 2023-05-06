package com.example.LuggagueTransformation.dto;


public class MessageResponse {
	
	private String message;
	int status;
	
	UserInfoResponse result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserInfoResponse getResult() {
		return result;
	}

	public void setResult(UserInfoResponse result) {
		this.result = result;
	}

	public MessageResponse(String message, int status, UserInfoResponse result) {
		super();
		this.message = message;
		this.status = status;
		this.result = result;
	}

	public MessageResponse(int status, String message) {
		this.message = message;
		this.status = status;
	}
	
	
	
	

}
