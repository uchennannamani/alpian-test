package com.uche.customermapperservice.dao;

import com.uche.customermapperservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
    Customer findByCustomerId(int customerId);

}
