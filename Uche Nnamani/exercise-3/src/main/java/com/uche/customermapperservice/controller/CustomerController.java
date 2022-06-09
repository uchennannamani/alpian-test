package com.uche.customermapperservice.controller;

import com.uche.customermapperservice.dao.CustomerRepository;
import com.uche.customermapperservice.exception.DateValidationException;
import com.uche.customermapperservice.model.Customer;
import com.uche.customermapperservice.service.DateValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class CustomerController {

    CustomerRepository customerRepository;
    DateValidationService dateValidationService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, DateValidationService dateValidationService) {
        this.customerRepository = customerRepository;
        this.dateValidationService = dateValidationService;
    }

    @PostMapping("/customers")
    public Customer storeCustomer(@RequestBody Customer customer) throws RuntimeException {
        customer.setExternalId(null);

        try {
            if (dateValidationService.isDateInTheFuture(customer.getCreatedDate())) {
                throw new DateValidationException("The date provided (" + customer.getCreatedDate()
                        + ") is in the future. Date should NOT be in the future.");
            } else {
                return customerRepository.save(customer);
            }
        } catch (DateValidationException dateValidationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, dateValidationException.getMessage(),
                    dateValidationException);
        } catch (RuntimeException runtimeException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A customer with Id: "
                    + customer.getCustomerId() + " already exists in the repository.", runtimeException);
        }
    }

    @GetMapping("/customers/{customerId}")
    public String getByCustomerId(@PathVariable int customerId) throws NoSuchElementException {

        Optional<Customer> customerOptional = customerRepository.findByCustomerId(customerId);

        if (customerOptional.isPresent()) {
            return customerOptional.get().getExternalId().toString();
        } else {
            throw new NoSuchElementException("Customer, with Id: " + customerId + ", Not Found in Repository");
        }
    }
}
