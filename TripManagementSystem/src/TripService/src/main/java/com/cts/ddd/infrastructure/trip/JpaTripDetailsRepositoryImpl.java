package com.cts.ddd.infrastructure.trip;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cts.ddd.domain.trip.TripDetails;
import com.cts.ddd.infrastructure.TripDetailsRepository;

public class JpaTripDetailsRepositoryImpl implements TripDetailsRepository {

	@Autowired
	private JpaTripDetailsRepository jpaTripDetailsRepository;
	
	@Override
	public TripDetails saveTripDetails(TripDetails tripDetails) {
		return jpaTripDetailsRepository.save(tripDetails);
	}

	@Override
	public Iterable<TripDetails> getAllTripDetails() {
		LookupOperation lookup = LookupOperation.newLookup().from("cars").localField("carsrefs._id").foreignField("_id")
				.as("cars");

		AggregationResults<Person> result = jpaTripDetailsRepository.aggregate(
				Aggregation.newAggregation(lookup, Aggregation.match(Criteria.where("cars.color").is(Color.RED.toString()))), "people",
				Person.class);

		AggregationResults<TripDetails> groupResults
		= mongoTemplate.aggregate(agg, User.class, HostingCount.class);
	List<TripDetails> result = groupResults.getMappedResults();
	
		return result.getMappedResults();
		
		Iterable<TripDetails> tripDetails = null;
		try {
			tripDetails = jpaTripDetailsRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------"+tripDetails);
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
