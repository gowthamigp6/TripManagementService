package com.cts.ddd.domain.employee;

import lombok.Data;

@Data
public class Location {

	private static final long serialVersionUID = 1L;

	private String fromLocation;

	private String toLocation;

	public Location() {
	}

	public Location(String fromLocation, String toLocation) {
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}

}
