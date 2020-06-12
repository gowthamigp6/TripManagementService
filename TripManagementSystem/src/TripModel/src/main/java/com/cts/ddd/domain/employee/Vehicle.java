package com.cts.ddd.domain.employee;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Vehicle  {

	private static final long serialVersionUID = 1L;

    private String vehicleType;

    private Integer seater;
    
    private BigDecimal travelCost;
    
    public Vehicle() {
    }

	public Vehicle(String vehicleType, Integer seater, BigDecimal travelCost) {
		this.vehicleType = vehicleType;
		this.seater = seater;
		this.travelCost = travelCost;
	}

	
}
