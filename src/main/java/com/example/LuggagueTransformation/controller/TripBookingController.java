package com.example.LuggagueTransformation.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LuggagueTransformation.Repo.TripBookingRepository;
import com.example.LuggagueTransformation.Repo.TripDetailsRepository;
import com.example.LuggagueTransformation.Repo.UserRepository;
import com.example.LuggagueTransformation.dto.MessageResponse;
import com.example.LuggagueTransformation.dto.TripBookingDto;
import com.example.LuggagueTransformation.dto.TripBookingResponseDto;
import com.example.LuggagueTransformation.dto.TripbookingResDto;
import com.example.LuggagueTransformation.models.TripBooking;
import com.example.LuggagueTransformation.models.TripDetails;
import com.example.LuggagueTransformation.models.User;
import com.example.LuggagueTransformation.util.ConstantUtils;

@CrossOrigin(origins="*")
@RestController
public class TripBookingController {
	
	@Autowired
	TripDetailsRepository tripDetailsRepository;
	
	@Autowired
	TripBookingRepository tripBookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@GetMapping("/user/getBookingByuserId/{userId}")
	private List<TripBookingResponseDto> getTripBooking(@PathVariable("userId") Long userId) {
		List<TripBooking> TripDetailsList = tripBookingRepository.findAllByuserIdAndstatusOrderBycreatedDate(userId,ConstantUtils.Active);
		List<TripBookingResponseDto> tripBookingResponseDtoList =new ArrayList<TripBookingResponseDto>();
		for(TripBooking  trip : TripDetailsList) {
			User user=userRepository.findById(trip.getTripDetails().getUserId()).get();
			TripBookingResponseDto tripBookingResponseDto = new TripBookingResponseDto();
			tripBookingResponseDto.setTripBooking(trip);
			tripBookingResponseDto.setUser(user);
			tripBookingResponseDtoList.add(tripBookingResponseDto);
		}
		return tripBookingResponseDtoList;
	}

	@GetMapping("/getBookingByuserIdandStatus/{userId}/{status}")
	private List<TripBookingResponseDto> getTripBookingandStatus(@PathVariable("userId") Long userId,@PathVariable("status") String tripStatus) {
		List<TripBooking> TripDetailsList = tripBookingRepository.findAllByuserIdAndpickupStatus(userId,tripStatus,ConstantUtils.Active);
		List<TripBookingResponseDto> tripBookingResponseDtoList =new ArrayList<TripBookingResponseDto>();
		TripBookingResponseDto tripBookingResponseDto = new TripBookingResponseDto();
		for(TripBooking  trip : TripDetailsList) {
			User user=userRepository.findById(trip.getTripDetails().getUserId()).get();
			tripBookingResponseDto.setTripBooking(trip);
			tripBookingResponseDto.setUser(user);
			tripBookingResponseDtoList.add(tripBookingResponseDto);
			
		}
		return tripBookingResponseDtoList;
	}
	
	@PostMapping("/addNewBooking")
	public ResponseEntity<?> saveBook(@RequestBody TripBookingDto tripBookingDto) {
		TripBooking tripBooking = new TripBooking();
		SimpleDateFormat formatter6 = new SimpleDateFormat(ConstantUtils.dateFormatwithtime);
		Date startdate;
		try{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConstantUtils.dateFormatwithtime);
			LocalDateTime now = LocalDateTime.now();
			String date = dtf.format(now);
			startdate = formatter6.parse(date);
			TripDetails tripDetails=tripDetailsRepository.findById(tripBookingDto.getTripDetailsId()).get();
			tripBooking.setPickupLocation(tripBookingDto.getPickupLocation());
			tripBooking.setPickupStatus(tripBookingDto.getPickupStatus());
			tripBooking.setCreatedDate(startdate);
			tripBooking.setUserId(tripBookingDto.getUserId());
			tripBooking.setTripDetails(tripDetails);
			tripBooking.setStatus(tripBookingDto.getStatus());
			tripBookingRepository.save(tripBooking);
			return ResponseEntity.ok().body(new MessageResponse( HttpStatus.OK.value(),"Booking is added sucessfully"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok().body(new MessageResponse( HttpStatus.BAD_REQUEST.value(),"Booking is added sucessfully"));
		}
	}
	
	@GetMapping("/user/deleteBooking/{bookingId}")
	private ResponseEntity<?> deleteTripBooking(@PathVariable("bookingId") Long id) {
		TripBooking tripBookingList = tripBookingRepository.findById(id).get();
		tripBookingList.setStatus("inactive");
		tripBookingList.setPickupStatus("cancelled");
		tripBookingRepository.save(tripBookingList);
		return ResponseEntity.ok().body(new MessageResponse( HttpStatus.OK.value(),"Booking is deleted sucessfully"));
	}
	
	
	@GetMapping("/user/getBookingByTripId/{tripid}")
	private List<?> getTripBookingBYId(@PathVariable("tripid") Long tripid) {
		TripDetails tripDetails =tripDetailsRepository.findById(tripid).get();
		List<TripBooking> TripDetailsList = tripBookingRepository.findAllByTripDetailsId(tripDetails.getId());
		List<TripbookingResDto> tripbookingResDtoList =new ArrayList();
		for(TripBooking tripBooking:TripDetailsList) {
			TripbookingResDto tripbookingResDto = new TripbookingResDto();
			User user = userRepository.findUserById(tripBooking.getUserId());
			if(user !=null) {
			tripbookingResDto.setEmail(user.getEmail());
			tripbookingResDto.setMobileNo(user.getMobileNo());
			}
			tripbookingResDto.setCreatedDate(tripBooking.getCreatedDate());
			tripbookingResDto.setPickupLocation(tripBooking.getPickupLocation());
			tripbookingResDto.setPickupStatus(tripBooking.getPickupStatus());
			tripbookingResDto.setUserId(tripBooking.getUserId());
			tripbookingResDtoList.add(tripbookingResDto);
		}
		return tripbookingResDtoList;
	}

	
	
}
