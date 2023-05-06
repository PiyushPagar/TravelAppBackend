package com.example.LuggagueTransformation.dto;

import com.example.LuggagueTransformation.models.TripBooking;
import com.example.LuggagueTransformation.models.User;


public class TripBookingResponseDto {
	
	
	public TripBooking tripBooking;
	
	public User user;

	public TripBooking getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
