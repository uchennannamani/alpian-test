package com.uche.customermapperservice;

import com.uche.customermapperservice.dao.CustomerRepository;
import com.uche.customermapperservice.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CustomerMapperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMapperServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		// Populate the in-memory database with some data.
		return args -> {
			customerRepository.save(new Customer(1, LocalDate.parse("2021-11-25")));
			customerRepository.save(new Customer(2, LocalDate.parse("2020-09-15")));
			customerRepository.save(new Customer(3, LocalDate.parse("2019-09-25")));
		};
	}
}
