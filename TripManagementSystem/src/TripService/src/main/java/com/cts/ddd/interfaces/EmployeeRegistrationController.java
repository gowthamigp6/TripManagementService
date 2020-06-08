package com.cts.ddd.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ddd.application.EmployeeRegistrationService;
import com.cts.ddd.domain.employee.EmployeeRegistration;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class EmployeeRegistrationController {

	@Autowired
	private EmployeeRegistrationService service;

	@PostMapping(value = "/employeeRegistration/create")
	public ResponseEntity<String> createUser(@RequestBody EmployeeRegistration reg) {
		String message = "";
		EmployeeRegistration empReg = service.registerVehicle(reg);
		if (empReg != null) {
			message = "Employee Details Saved Successfully";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} else {
			message = "Error in saving the employee details";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

	}

	@GetMapping(value = "/employeeRegistration/get", headers = "Accept=application/json")
	public @ResponseBody Iterable<EmployeeRegistration> getAllEmployeeDetails() {
		return service.getAllEmployeeDetails();
	}

}
