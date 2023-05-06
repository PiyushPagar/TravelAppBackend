package com.example.LuggagueTransformation.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.LuggagueTransformation.models.TripBooking;


public interface TripBookingRepository extends CrudRepository<TripBooking, Long>{

//	List<TripBooking> findAllByuserId(Long userId);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM travelapp.trip_bookings where user_id=:userId and pickup_status=:status and Status =:active order by created_date asc;", nativeQuery = true)
	List<TripBooking> findAllByuserIdAndpickupStatus(@Param("userId")Long userId, @Param("status")String status,@Param("active")String active);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM travelapp.trip_bookings where user_id=:userId and Status =:Status order by created_date asc;", nativeQuery = true)
	List<TripBooking> findAllByuserIdAndstatusOrderBycreatedDate(@Param("userId")Long userId,@Param("Status") String Status);

	List<TripBooking> findAllByTripDetailsId(Long id);
	
	
}
