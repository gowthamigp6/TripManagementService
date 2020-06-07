package com.cts.ddd.application;

import com.cts.ddd.domain.employee.EmployeeRegistration;

public interface EmployeeRegistrationService {

	EmployeeRegistration registerVehicle(EmployeeRegistration employee);

	Iterable<EmployeeRegistration> getAllEmployeeDetails();
}
