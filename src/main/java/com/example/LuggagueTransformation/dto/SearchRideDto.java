package com.example.LuggagueTransformation.dto;

import java.util.Date;

public class SearchRideDto {
	
	public String tripStartFrom;
	
	public String tripEndTo;
	
	private String tripStatus;
	

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

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}



}
