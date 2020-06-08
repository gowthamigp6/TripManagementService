package com.cts.ddd.infrastructure.trip;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.ddd.domain.trip.TripDetails;

@Repository
public interface JpaTripDetailsRepository extends MongoRepository<TripDetails, String> {

	 @Query("{ 'user.userId=' : ?0 }")
	//@Query("from TripDetails trip where trip.user.userId=:userId")
	List<TripDetails> getCustomerTripDetails(String userId);
	
	 @Query("{ 'registration.user.userId=' : ?0 }")
	//@Query("from TripDetails trip where trip.employeeRegistration.user.userId=:userId")
	List<TripDetails> getEmployeeTripDetails(String userId);
}
