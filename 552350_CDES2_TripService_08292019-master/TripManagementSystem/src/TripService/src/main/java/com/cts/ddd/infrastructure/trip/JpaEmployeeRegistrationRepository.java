package com.cts.ddd.infrastructure.trip;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cts.ddd.domain.employee.EmployeeRegistration;

@Repository
public interface JpaEmployeeRegistrationRepository extends MongoRepository<EmployeeRegistration, String> {

}
