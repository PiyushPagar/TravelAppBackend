package com.example.LuggagueTransformation.models;

import java.util.Date;

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
	

	
	
	public TripDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "tripStartTime")
	private Date tripStartTime;
	@Column(name = "tripEndTime")
	private Date tripEndTime;
	
	
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
	
	@Column(name = "tripStatus")
	private String tripStatus;


	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public Date getTripStartTime() {
		return tripStartTime;
	}

	public void setTripStartTime(Date tripStartTime) {
		this.tripStartTime = tripStartTime;
	}

	public Date getTripEndTime() {
		return tripEndTime;
	}

	public void setTripEndTime(Date tripEndTime) {
		this.tripEndTime = tripEndTime;
	}

	public TripDetails(Long id, Long userId, Date tripStartTime, Date tripEndTime,
			String tripStartFrom, String tripEndTo, String capacity, String vehicleName, String vehicleDetails,
			String tripPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.tripStartTime = tripStartTime;
		this.tripEndTime = tripEndTime;
		this.tripStartFrom = tripStartFrom;
		this.tripEndTo = tripEndTo;
		Capacity = capacity;
		VehicleName = vehicleName;
		VehicleDetails = vehicleDetails;
		this.tripPrice = tripPrice;
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
