package com.cts.ddd.domain.trip;

import org.apache.commons.lang.builder.EqualsBuilder;
import com.cts.ddd.domain.shared.ValueObject;
import lombok.Data;

@Data
public class TravelDetails implements ValueObject<TravelDetails> {

	private static final long serialVersionUID = 1L;

	private String travelTime;

    private String travelStatus;
    
    public TravelDetails() {
    }
    
	public TravelDetails(String travelTime, String travelStatus) {
		this.travelTime = travelTime;
		this.travelStatus = travelStatus;
	}


	@Override
	public boolean sameValueAs(TravelDetails other) {
		 return other != null && new EqualsBuilder().
			      append(this.travelTime, other.travelTime).
			      append(this.travelStatus, other.travelStatus).
			      isEquals();
	}

}
