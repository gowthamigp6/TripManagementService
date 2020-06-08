package com.cts.ddd.infrastructure;

import com.cts.ddd.domain.employee.EmployeeRegistration;

public interface EmployeeRegistrationRepository {

    EmployeeRegistration registerVehicle(EmployeeRegistration employee);
	
	Iterable<EmployeeRegistration> getAllEmployeeDetails();
	
}
