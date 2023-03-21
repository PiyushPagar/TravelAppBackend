package com.example.LuggagueTransformation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TripDetails")
public class TripDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "tripTime")
	private String tripTime;
	
	
	@Column(name = "tripStartTime")
	private String tripStartTime;
	@Column(name = "tripEndTime")
	private String tripEndTime;
	
	
	@Column(name = "tripStartFrom")
	private String tripStartFrom;
	
	@Column(name = "tripEndTo")
	private String tripEndTo;

	@Column(name = "Capacity")
	private String Capacity;
	
	@Column(name = "VehicleName")
	private String VehicleName;
	
	@Column(name = "VehicleDetails")
	private String VehicleDetails;
	
	@Column(name = "tripPrice")
	private String tripPrice;
	
	
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

	public String getVehicleName() {
		return VehicleName;
	}

	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

	public String getTripPrice() {
		return tripPrice;
	}

	public void setTripPrice(String tripPrice) {
		this.tripPrice = tripPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTripTime() {
		return tripTime;
	}

	public void setTripTime(String tripTime) {
		this.tripTime = tripTime;
	}
	

	

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getVehicleDetails() {
		return VehicleDetails;
	}

	public void setVehicleDetails(String vehicleDetails) {
		VehicleDetails = vehicleDetails;
	}

	
	
	
	
	

}
