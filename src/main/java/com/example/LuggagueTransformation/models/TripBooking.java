package com.example.LuggagueTransformation.models;



import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="TripBookings")
public class TripBooking {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "pickup_location")
	private String pickupLocation;
	
	@Column(name = "pickupStatus")
	private String pickupStatus;
	
	@Column(name = "createdDate")
	private Date createdDate;
		

	@Column(name = "Status")
	private String status;
	
	
	@ManyToOne(targetEntity = TripDetails.class)
	@JoinColumn(name = "tripDetails_id")
	@JsonIgnore
	private TripDetails tripDetails;


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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public TripDetails getTripDetails() {
		return tripDetails;
	}


	public void setTripDetails(TripDetails tripDetails) {
		this.tripDetails = tripDetails;
	}

	

	

}
