package com.cts.ddd.infrastructure.trip;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.ddd.domain.employee.EmployeeRegistration;
import com.cts.ddd.infrastructure.EmployeeRegistrationRepository;

public class JpaEmployeeRegistrationRepositoryImpl implements EmployeeRegistrationRepository {

	@Autowired
	private JpaEmployeeRegistrationRepository employeeRegistrationRepository;
	
	@Override
	public EmployeeRegistration registerVehicle(EmployeeRegistration employee) {
		return employeeRegistrationRepository.save(employee);
	}

	@Override
	public Iterable<EmployeeRegistration> getAllEmployeeDetails() {
		return employeeRegistrationRepository.findAll();
	}

	
}
