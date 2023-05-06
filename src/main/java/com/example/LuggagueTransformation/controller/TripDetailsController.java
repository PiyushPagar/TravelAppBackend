package com.example.LuggagueTransformation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LuggagueTransformation.Repo.TripDetailsRepository;
import com.example.LuggagueTransformation.dto.MessageResponse;
import com.example.LuggagueTransformation.dto.TripDetailsDto;
import com.example.LuggagueTransformation.models.TripDetails;
import com.example.LuggagueTransformation.util.ConstantUtils;

@CrossOrigin(origins = "*")
@RestController
public class TripDetailsController {

	@Autowired
	TripDetailsRepository tripDetailsRepository;

	@PostMapping("/addNewTrip")
	private MessageResponse saveBook(@RequestBody TripDetailsDto tripDetailsDto) {
		TripDetails tripDetails = new TripDetails();
		SimpleDateFormat formatter6 = new SimpleDateFormat(ConstantUtils.dateFormatwithtime);
		Date startdate;
		Date endDate;
		try {
			startdate = formatter6.parse(tripDetailsDto.getTripStartTime());
			endDate = formatter6.parse(tripDetailsDto.getTripEndTime());
			tripDetails.setCapacity(tripDetailsDto.getCapacity());
			tripDetails.setTripEndTime(endDate);
			tripDetails.setTripEndTo(tripDetailsDto.getTripEndTo());
			tripDetails.setTripPrice(tripDetailsDto.getTripPrice());
			tripDetails.setTripStartFrom(tripDetailsDto.getTripStartFrom());
			tripDetails.setTripStartTime(startdate);
			tripDetails.setTripStatus(tripDetailsDto.getTripStatus());
			tripDetails.setUserId(tripDetailsDto.getUserId());
			tripDetails.setVehicleDetails(tripDetailsDto.getVehicleDetails());
			tripDetails.setVehicleName(tripDetailsDto.getVehicleName());
			tripDetailsRepository.save(tripDetails);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return new MessageResponse( HttpStatus.OK.value(),"Trip added sucessfully");
	}

	@GetMapping("/getgetTripDetailsbyuserid/{userId}")
	private List<TripDetails> getTripDetails(@PathVariable("userId") int userId) {
		Long users=new Long(userId);
		List<TripDetails> TripDetailsList = tripDetailsRepository.findAllByUserId(users);
		return TripDetailsList;
	}

	@DeleteMapping("/deleteapplicationform/")
	private void deleteBook(@PathVariable("Id") Long Id) {
		TripDetails tripDetails = tripDetailsRepository.findById(Id).get();
		tripDetailsRepository.delete(tripDetails);
	}

	@GetMapping("/getTripDetailsbysearch/{tripStartFrom}/{tripEndTo}")
	public List<TripDetails> getTripDetailsbysearch(@PathVariable String tripStartFrom,@PathVariable String tripEndTo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		List<TripDetails> TripDetailsList = tripDetailsRepository.findAllBydistinationAndtime(
				tripStartFrom, tripEndTo, ConstantUtils.initialStatus, date);

		return TripDetailsList;
	}
	
	

//	public static Date toDate(String string, String format) {
//		try {
//			Date d = new SimpleDateFormat(format).parse(string);
//			return new java.sql.Date(d.getTime());
//		} catch (ParseException e) {
//			return null;
//		}
//	}
//
//	public static String currentformatDateTime(String format) {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
//		LocalDateTime now = LocalDateTime.now();
//		return dtf.format(now);
//	}

}
