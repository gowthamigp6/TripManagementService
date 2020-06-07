package com.cts.ddd.application;

import java.util.List;
import com.cts.ddd.domain.trip.TripDetails;


public interface TripService {

	TripDetails saveTripDetails(TripDetails tripDetails);

	Iterable<TripDetails> getAllTripDetails();

	List<TripDetails> getEmployeeTripDetails(String userId);

	List<TripDetails> getCustomerTripDetails(String userId);

	
}
