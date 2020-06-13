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
			try {
				
				if(tripDetails.getTravelDate()!=null)
				tripDetailsDTO.setTravelDate(tripDetails.getTravelDate());

				if (tripDetails.getRegistration() != null) {
					tripDetailsDTO.setVehicleNo(tripDetails.getRegistration().getVehicleNo());
					tripDetailsDTO
							.setEmployeeName(tripDetails.getRegistration().getUser().getFullName().getFirstName());
					tripDetailsDTO.setFromLocation(tripDetails.getRegistration().getLocation().getFromLocation());
					tripDetailsDTO.setToLocation(tripDetails.getRegistration().getLocation().getToLocation());

					tripDetailsDTO.setVehicleType(tripDetails.getRegistration().getVehicle().getVehicleType());
					tripDetailsDTO.setSeater(tripDetails.getRegistration().getVehicle().getSeater());
					tripDetailsDTO.setTravelCost(tripDetails.getRegistration().getVehicle().getTravelCost());
				}

				if (tripDetails.getTravelDetails() != null) {
					tripDetailsDTO.setTravelTime(tripDetails.getTravelDetails().getTravelTime());
					tripDetailsDTO.setTravelStatus(tripDetails.getTravelDetails().getTravelStatus());
				}

				if (tripDetails.getUser() != null) {
					tripDetailsDTO.setCustomerName(tripDetails.getUser().getFullName().getFirstName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tripDetailsDTO;
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
