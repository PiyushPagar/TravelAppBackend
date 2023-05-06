package com.example.LuggagueTransformation.dto;



public class TripDetailsDto {
	
	private Long userId;
	
	private String tripStartTime;

	private String tripEndTime;
	
	
	private String tripStartFrom;
	
	private String tripEndTo;

	private String Capacity;
	
	private String VehicleName;
	
	private String VehicleDetails;
	
	private String tripPrice;
	
	private String tripStatus;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTripStartTime() {
		return tripStartTime;
	}

	public void setTripStartTime(String tripStartTime) {
		this.tripStartTime = tripStartTime;
	}

	public String getTripEndTime() {
		return tripEndTime;
	}

	public void setTripEndTime(String tripEndTime) {
		this.tripEndTime = tripEndTime;
	}

	public String getTripStartFrom() {
		return tripStartFrom;
	}

	public void setTripStartFrom(String tripStartFrom) {
		this.tripStartFrom = tripStartFrom;
	}

	public String getTripEndTo() {
		return tripEndTo;
	}

	public void setTripEndTo(String tripEndTo) {
		this.tripEndTo = tripEndTo;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getVehicleName() {
		return VehicleName;
	}

	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

	public String getVehicleDetails() {
		return VehicleDetails;
	}

	public void setVehicleDetails(String vehicleDetails) {
		VehicleDetails = vehicleDetails;
	}

	public String getTripPrice() {
		return tripPrice;
	}

	public void setTripPrice(String tripPrice) {
		this.tripPrice = tripPrice;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	

}
