package com.reactivespring.demo;

import com.reactivespring.demo.model.Employee;
import com.reactivespring.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner employees(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository
					.deleteAll()
					.subscribe(null, null, ()->{
						Stream.of(new Employee(UUID.randomUUID().toString(), "Peter", 23000L),
								new Employee(UUID.randomUUID().toString(), "Sam", 23000L),
								new Employee(UUID.randomUUID().toString(), "Ryan", 23000L),
								new Employee(UUID.randomUUID().toString(), "Chris", 23000L))
								.forEach(employee -> {
									employeeRepository
											.save(employee)
											.subscribe(System.out::println);
								});
					});
		};
	}
}
