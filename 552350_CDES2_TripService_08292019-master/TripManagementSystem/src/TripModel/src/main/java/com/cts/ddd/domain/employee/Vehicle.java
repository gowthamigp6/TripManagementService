package com.cts.ddd.domain.employee;

import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.cts.ddd.domain.shared.ValueObject;
import lombok.Data;

@Data
public class Vehicle implements ValueObject<Vehicle> {

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



	@Override
	public boolean sameValueAs(Vehicle other) {
		 return other != null && new EqualsBuilder().
			      append(this.vehicleType, other.vehicleType).
			      append(this.seater, other.seater).
			      append(this.travelCost, other.travelCost).
			      isEquals();
	}
	
}
