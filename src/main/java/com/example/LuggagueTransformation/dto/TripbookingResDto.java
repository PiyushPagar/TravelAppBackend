package com.example.LuggagueTransformation.dto;

import java.util.Date;

public class TripbookingResDto {
	
	private Long userId;
	private String pickupLocation;
	private String pickupStatus;
	private Date createdDate;
	private String email;
	private String mobileNo;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getPickupStatus() {
		return pickupStatus;
	}
	public void setPickupStatus(String pickupStatus) {
		this.pickupStatus = pickupStatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
}
