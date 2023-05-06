package com.example.LuggagueTransformation.Repo;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.LuggagueTransformation.models.TripDetails;

public interface TripDetailsRepository extends CrudRepository<TripDetails, Long> {

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM travelapp.trip_details where user_id=:userId order by trip_start_time desc;", nativeQuery = true)
	List<TripDetails> findAllByUserId(@Param("userId") Long userId);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM travelapp.trip_details where trip_start_from=:tripStartFrom and trip_end_to=:tripEndTo and trip_start_time >=:date6 and trip_status=:tripStatus order by trip_start_time asc;", nativeQuery = true)
	List<TripDetails> findAllBydistinationAndtime(@Param("tripStartFrom") String tripStartFrom,@Param("tripEndTo") String tripEndTo,
			 @Param("tripStatus")String tripStatus, @Param("date6") String date6);

	List<TripDetails> findAllByUserIdOrderByTripStartFromDesc(Long users);

//	void updatepasswordwithemail(@Param("email") String email, @Param("password") String password);    
}
