package com.uche.customermapperservice.controller;

import com.uche.customermapperservice.dao.CustomerRepository;
import com.uche.customermapperservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customers")
    public Customer storeCustomer(@RequestBody Customer customer) {
        customer.setExternalId(null);



        return customerRepository.save(customer);
    }

    @GetMapping("/customers/{customerId}")
    public String getCustomerExternalId(@PathVariable int customerId) {
        Customer customerOptional = customerRepository.findByCustomerId(customerId);
        return customerOptional.getExternalId().toString();
    }


    // remove this method
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
