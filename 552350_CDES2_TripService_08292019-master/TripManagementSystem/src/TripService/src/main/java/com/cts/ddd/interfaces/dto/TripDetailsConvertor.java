package com.cts.ddd.interfaces.dto;

import org.springframework.stereotype.Component;

import com.cts.ddd.domain.trip.TripDetails;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

@Component
public class TripDetailsConvertor implements Converter {

	@Override
	public Object convert(Object value) {
		if (value == null) {
			return null;

		} else if (value instanceof TripDetails) {
			TripDetails tripDetails = (TripDetails) value;
			TripDetailsDTO tripDetailsDTO = new TripDetailsDTO();
			tripDetailsDTO.setTravelDate(tripDetails.getTravelDate());
			tripDetailsDTO.setVehicleNo(tripDetails.getRegistration().getVehicleNo());
			
			tripDetailsDTO.setTravelTime(tripDetails.getTravelDetails().getTravelTime());
			tripDetailsDTO.setTravelStatus(tripDetails.getTravelDetails().getTravelStatus());

			tripDetailsDTO.setCustomerName(tripDetails.getUser().getFullName().getFirstName());
			
			tripDetailsDTO.setEmployeeName(tripDetails.getRegistration().getUser().getFullName().getFirstName());
			tripDetailsDTO.setFromLocation(tripDetails.getRegistration().getLocation().getFromLocation());
			tripDetailsDTO.setToLocation(tripDetails.getRegistration().getLocation().getToLocation());

			tripDetailsDTO.setVehicleType(tripDetails.getRegistration().getVehicle().getVehicleType());
			tripDetailsDTO.setSeater(tripDetails.getRegistration().getVehicle().getSeater());
			tripDetailsDTO.setTravelCost(tripDetails.getRegistration().getVehicle().getTravelCost());
			return tripDetails;
		}

		return null;
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return null;
	}

}
