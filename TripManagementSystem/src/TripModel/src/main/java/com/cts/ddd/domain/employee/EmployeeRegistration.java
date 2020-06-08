package com.cts.ddd.domain.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cts.ddd.domain.user.User;
import lombok.Data;

@Document(collection="registration")
@Data
public class EmployeeRegistration {

	@Id
	private String vehicleNo;

	private Location location;

	private Vehicle vehicle;

	@DBRef(db="user",lazy = true)
	private User user;

	public EmployeeRegistration() {
	}

	@PersistenceConstructor
	public EmployeeRegistration(String vehicleNo, Location location, Vehicle vehicle, User userId) {
		this.vehicleNo = vehicleNo;
		this.location = location;
		this.vehicle = vehicle;
		this.user = user;
	}

}