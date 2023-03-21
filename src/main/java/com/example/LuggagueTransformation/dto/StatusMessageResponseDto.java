package com.example.LuggagueTransformation.dto;

public class StatusMessageResponseDto{
	//OtpMessageResponse	
		private String message;
		int status;
		
		
		public StatusMessageResponseDto(int status,String message) {
			super();
			this.message = message;
			this.status = status;
		}
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

	}