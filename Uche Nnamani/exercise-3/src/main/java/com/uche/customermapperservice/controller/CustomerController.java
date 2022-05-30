package com.uche.customermapperservice.controller;

import com.uche.customermapperservice.dao.CustomerRepository;
import com.uche.customermapperservice.exception.DateValidationException;
import com.uche.customermapperservice.model.Customer;
import com.uche.customermapperservice.service.DateValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DateValidationService dateValidationService;

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
    public String getByCustomerId(@PathVariable int customerId) {

        try {
            Customer customerOptional = customerRepository.findByCustomerId(customerId);
            return customerOptional.getExternalId().toString();
        } catch (NullPointerException nullPointerException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer, with Id: "
                    + customerId + ", Not Found in Repository", nullPointerException);
        }
    }
}
