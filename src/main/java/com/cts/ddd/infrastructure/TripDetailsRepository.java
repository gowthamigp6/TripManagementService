package com.cts.ddd.infrastructure;

import java.util.List;

import com.cts.ddd.domain.trip.TripDetails;

public interface TripDetailsRepository {

	TripDetails saveTripDetails(TripDetails tripDetails);
	
	Iterable<TripDetails> getAllTripDetails();
	
	List<TripDetails> getCustomerTripDetails(String userId);
	
	List<TripDetails> getEmployeeTripDetails(String userId);
}
