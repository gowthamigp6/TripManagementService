package com.cts.ddd.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ddd.application.TripService;
import com.cts.ddd.domain.trip.TripDetails;
import com.cts.ddd.interfaces.dto.TripDetailsConvertor;
//import com.cts.ddd.domain.user.User;
import com.cts.ddd.interfaces.dto.TripDetailsDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//import javax.inject.Inject;

@RibbonClient(name = "trip-service")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class TripDetailsController {

	@Autowired
	private TripService tripService;
	
	@Autowired
	private TripDetailsConvertor tripDetailsConvertor;

	public List<TripDetailsDTO> fallback() {
		return new ArrayList<TripDetailsDTO>();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping(value = "/tripDetails/get", headers = "Accept=application/json")
	public @ResponseBody List<TripDetailsDTO> getAllTripDetails() {
		Iterable<TripDetails> tripDetailsList = tripService.getAllTripDetails();
		List<TripDetailsDTO> tripDetailsDTOList = new ArrayList<TripDetailsDTO>();
		for (TripDetails tripDetails : tripDetailsList) {
			tripDetailsDTOList.add((TripDetailsDTO) tripDetailsConvertor.convert(tripDetails));
		}
		System.out.println(tripDetailsDTOList);
		return tripDetailsDTOList;
	}

	@GetMapping(value = "/tripDetails/customer/{userId}", headers = "Accept=application/json")
	public @ResponseBody List<TripDetailsDTO> getCustomerTripDetails(@PathVariable("userId") String userId) {
		Iterable<TripDetails> tripDetailsList = tripService.getCustomerTripDetails(userId);
		List<TripDetailsDTO> tripDetailsDTOList = new ArrayList<TripDetailsDTO>();
		
		for (TripDetails tripDetails : tripDetailsList) {
			
			tripDetailsDTOList.add((TripDetailsDTO) tripDetailsConvertor.convert(tripDetails));
		}
		System.out.println(tripDetailsDTOList);
		return tripDetailsDTOList;
	}

	@GetMapping(value = "/tripDetails/employee/{userId}", headers = "Accept=application/json")
	public @ResponseBody List<TripDetailsDTO> getEmployeeTripDetails(@PathVariable("userId") String userId) {
		Iterable<TripDetails> tripDetailsList = tripService.getEmployeeTripDetails(userId);
		List<TripDetailsDTO> tripDetailsDTOList = new ArrayList<TripDetailsDTO>();
		for (TripDetails tripDetails : tripDetailsList) {
			tripDetailsDTOList.add((TripDetailsDTO) tripDetailsConvertor.convert(tripDetails));
		}
		System.out.println(tripDetailsDTOList);
		return tripDetailsDTOList;
	}
}
