package com.cts.ddd.infrastructure.trip;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.ddd.domain.trip.TripDetails;
import com.cts.ddd.infrastructure.TripDetailsRepository;

public class JpaTripDetailsRepositoryImpl implements TripDetailsRepository {

	private final  Logger logger = Logger.getLogger(JpaTripDetailsRepositoryImpl.class.getName());
	
	@Autowired
	private JpaTripDetailsRepository jpaTripDetailsRepository;
	
	@Override
	public TripDetails saveTripDetails(TripDetails tripDetails) {
		return jpaTripDetailsRepository.save(tripDetails);
	}

	@Override
	public Iterable<TripDetails> getAllTripDetails() {
		Iterable<TripDetails> tripDetails = null;
		try {
			tripDetails = jpaTripDetailsRepository.findAll();
		}catch(Exception e) {
			logger.severe(e.getMessage());
		}
		logger.info("-------------"+tripDetails);
		return tripDetails;
	}

	@Override
	public List<TripDetails> getCustomerTripDetails(String userId) {
		return jpaTripDetailsRepository.getCustomerTripDetails(userId);
	}

	@Override
	public List<TripDetails> getEmployeeTripDetails(String userId) {
		return jpaTripDetailsRepository.getEmployeeTripDetails(userId);
	}

}
