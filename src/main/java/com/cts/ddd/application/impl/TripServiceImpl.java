package com.cts.ddd.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ddd.application.TripService;
import com.cts.ddd.domain.trip.TripDetails;
import com.cts.ddd.infrastructure.TripDetailsRepository;

@Service
@Transactional
public class TripServiceImpl implements TripService {
	
	@Autowired
	private TripDetailsRepository tripDetailsRepository;
	

	@Override
	public TripDetails saveTripDetails(TripDetails tripDetails) {
		return tripDetailsRepository.saveTripDetails(tripDetails);
	}

	@Override
	public Iterable<TripDetails> getAllTripDetails() {
		return tripDetailsRepository.getAllTripDetails();
	}

	@Override
	public List<TripDetails> getCustomerTripDetails(String userId) {
		return tripDetailsRepository.getCustomerTripDetails(userId);
	}

	@Override
	public List<TripDetails> getEmployeeTripDetails(String userId) {
		return tripDetailsRepository.getEmployeeTripDetails(userId);
	}

}
