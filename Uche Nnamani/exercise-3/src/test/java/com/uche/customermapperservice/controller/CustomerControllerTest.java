package com.uche.customermapperservice.controller;

import com.uche.customermapperservice.dao.CustomerRepository;
import com.uche.customermapperservice.service.DateValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)   // Pass in the actual controller under test
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private DateValidationService dateValidationService;

    @MockBean
    private CustomerRepository customerRepository;



    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(customerRepository.findByCustomerId(1).getExternalId().toString())
                .thenReturn("528e3d4-4a6e-4fb2-9494-0c43d762d535");
//        this.mockMvc.perform(get("/v1/api/cutomers")).

    }
}