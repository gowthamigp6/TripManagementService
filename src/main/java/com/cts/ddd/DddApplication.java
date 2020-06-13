package com.cts.ddd;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cts.ddd.application.EmployeeRegistrationService;
import com.cts.ddd.application.TripService;
import com.cts.ddd.domain.employee.EmployeeRegistration;
import com.cts.ddd.domain.employee.Location;
import com.cts.ddd.domain.employee.Vehicle;
import com.cts.ddd.domain.trip.TravelDetails;
import com.cts.ddd.domain.trip.TripDetails;
import com.cts.ddd.domain.user.Address;
import com.cts.ddd.domain.user.ContactInformation;
import com.cts.ddd.domain.user.FullName;
import com.cts.ddd.domain.user.User;

@SpringBootApplication
@EnableCircuitBreaker
//@EnableFeignClients
public class DddApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRegistrationService service;
	
	@Autowired
	private TripService tripService;

	public static void main(String[] args) {
		SpringApplication.run(DddApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setFromLocation("Chennai");
		location.setToLocation("Bangalore");

		Vehicle vehicle = new Vehicle();
		vehicle.setSeater(Integer.valueOf("4"));
		vehicle.setVehicleType("Car");
		
		vehicle.setTravelCost(new BigDecimal("5000.00"));

		EmployeeRegistration emp = new EmployeeRegistration();
		emp.setVehicleNo("TN1234");
		emp.setVehicle(vehicle);
		emp.setLocation(location);
		
		FullName fullName = new FullName("AdminUser", "AdminUser");
		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setEmailId("gow.cute@gmail.com");
		contactInformation.setTelephoneNo("1234567890");

		Address address = new Address();
		address.setCity("Vellore");
		address.setDoorNo("123");
		address.setPinCode("645678");
		address.setPlotNo("No.11");
		address.setStreetName("street 1");
		User user = new User("emp01", "password", "employee", fullName, contactInformation, address);
		emp.setUser(user);
		
		EmployeeRegistration empReg = service.registerVehicle(emp);
		if (empReg != null) {
			System.out.println("EmployeeRegistration Saved Successfully");
		} else {
			System.out.println("EmployeeRegistration Saved not Successfully");
		}
		
		TripDetails tripDetails = new TripDetails();
		User tripUser = new User("user01", "password", "customer", fullName, contactInformation, address);
		
		tripDetails.setUser(tripUser);
		tripDetails.setRegistration(emp);
		tripDetails.setTravelDate(new Date());
		
		TravelDetails travelDetails = new TravelDetails();
		travelDetails.setTravelStatus("Booked");
		travelDetails.setTravelTime("2:00 PM");
		tripDetails.setTravelDetails(travelDetails);
		
		TripDetails trip = tripService.saveTripDetails(tripDetails);
		if (trip != null) {
			System.out.println("TripDetails Saved Successfully");
		} else {
			System.out.println("TripDetails Saved not Successfully");
		}
	}
}
