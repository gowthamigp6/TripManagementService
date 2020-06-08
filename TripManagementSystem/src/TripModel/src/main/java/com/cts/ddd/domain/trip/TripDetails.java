package com.cts.ddd.domain.trip;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.cts.ddd.domain.employee.EmployeeRegistration;
import com.cts.ddd.domain.user.User;
import lombok.Data;

@Document(collection = "TripDetails")
@Data
public class TripDetails {

	@Id
	private String id;

	@DBRef(db="user",lazy=true)
    private User user;
	
    @DBRef(db="registration",lazy=true)
    private EmployeeRegistration registration;
	
	private Date travelDate;

	private TravelDetails travelDetails;

	public TripDetails() {
	}

	public TripDetails(String id, User user, EmployeeRegistration registration, Date travelDate,
			TravelDetails travelDetails) {
		this.id = id;
		this.user = user;
		this.registration = registration;
		this.travelDate = travelDate;
		this.travelDetails = travelDetails;
	}
	
}
