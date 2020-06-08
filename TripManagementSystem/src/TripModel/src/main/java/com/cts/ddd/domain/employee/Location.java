package com.cts.ddd.domain.employee;

import org.apache.commons.lang.builder.EqualsBuilder;
import com.cts.ddd.domain.shared.ValueObject;
import lombok.Data;

@Data
public class Location implements ValueObject<Location> {

	private static final long serialVersionUID = 1L;

	private String fromLocation;

	private String toLocation;

	public Location() {
	}

	public Location(String fromLocation, String toLocation) {
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}

	@Override
	public boolean sameValueAs(Location other) {
		return other != null && new EqualsBuilder().append(this.fromLocation, other.fromLocation)
				.append(this.toLocation, other.toLocation).isEquals();
	}

}
