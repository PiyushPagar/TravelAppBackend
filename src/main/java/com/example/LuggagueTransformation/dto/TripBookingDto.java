package com.example.LuggagueTransformation.dto;


public class TripBookingDto {

	private Long userId;
	
	private Long tripDetailsId;

	private String pickupLocation;

	private String pickupStatus;
	
	
	private String status;


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getTripDetailsId() {
		return tripDetailsId;
	}


	public void setTripDetailsId(Long tripDetailsId) {
		this.tripDetailsId = tripDetailsId;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
