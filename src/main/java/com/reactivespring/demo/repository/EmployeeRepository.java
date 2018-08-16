package com.reactivespring.demo.repository;

import com.reactivespring.demo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{
}
