package com.cts.ddd.domain.trip;

import lombok.Data;

@Data
public class TravelDetails {

	private static final long serialVersionUID = 1L;

	private String travelTime;

    private String travelStatus;
    
    public TravelDetails() {
    }
    
	public TravelDetails(String travelTime, String travelStatus) {
		this.travelTime = travelTime;
		this.travelStatus = travelStatus;
	}

}
