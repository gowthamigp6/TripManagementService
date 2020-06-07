package com.cts.ddd.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ddd.application.EmployeeRegistrationService;
import com.cts.ddd.domain.employee.EmployeeRegistration;
import com.cts.ddd.infrastructure.EmployeeRegistrationRepository;



@Service
@Transactional
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService{

	@Autowired
	private EmployeeRegistrationRepository empRepository;
	
	@Override
	public EmployeeRegistration registerVehicle(EmployeeRegistration employee) {
		return empRepository.registerVehicle(employee);
	}

	@Override
	public Iterable<EmployeeRegistration> getAllEmployeeDetails() {
		return empRepository.getAllEmployeeDetails();
	}

}
