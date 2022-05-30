package com.uche.customermapperservice;

import com.uche.customermapperservice.controller.CustomerController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = CustomerMapperServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerMapperServiceApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Testing if the application context can load")
    @Order(1)
    void contextLoads() {

    }

    @Test
    @DisplayName("Testing if the application context can load and create a controller")
    @Order(2)
    public void contextLoadsWithAssertion() throws Exception {
        assertThat(customerController).isNotNull();
    }

    @Test
    @DisplayName("Testing the GET endpoint. Assert if a UUID pattern is returned")
    @Order(3)
    public void getEndpointReturnsUuidString() throws Exception {

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/api/customers/1",
                String.class)).matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}");
    }

//    @Test
//    @DisplayName("Testing the GET endpoint. Assert if a UUID pattern is returned")
//    @Order(4)
//    public void postEndpointReturnsUuidString() throws Exception {
//
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/api/customers",
//                Customer.class)).matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}");
//    }
}

// test for different date inputs (past, today, future)
// test for class in customerId
// test for date format error