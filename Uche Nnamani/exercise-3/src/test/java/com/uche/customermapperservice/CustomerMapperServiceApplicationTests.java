package com.uche.customermapperservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uche.customermapperservice.controller.CustomerController;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = CustomerMapperServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerMapperServiceApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private TestRestTemplate restTemplate;
    String baseUrl;
    String uuidPattern;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/v1/api/customers";
        uuidPattern = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}";
    }

    @Test
    @DisplayName("Testing if the application context can load")
    @Order(1)
    void contextLoads() {

    }

    @Test
    @DisplayName("Testing if the application context can create a controller")
    @Order(2)
    public void contextLoadsWithAssertion() throws Exception {
        assertThat(customerController).isNotNull();
    }

    @Test
    @DisplayName("Testing the GET endpoint. Assert if a UUID pattern is returned")
    @Order(3)
    public void getEndpointReturnsUuidString() throws Exception {
        assertThat(this.restTemplate.getForObject(baseUrl + "/1", String.class)).matches(uuidPattern);
    }

    @Test
    @DisplayName("Testing the POST endpoint.")
    @Order(4)
    public void postEndpointTest() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();

        JSONObject customerObject = new JSONObject();
        customerObject.put("customerId", 4);
        customerObject.put("createdDate", "2021-03-02");

        HttpEntity<String> requestBody = new HttpEntity<String>(customerObject.toString(), httpHeaders);

        String customerAsJsonString = this.restTemplate.postForObject(baseUrl, requestBody, String.class);
        JsonNode customerJsonNode = objectMapper.readTree(customerAsJsonString);

        assertNotNull(customerAsJsonString);
        assertNotNull(customerJsonNode);
        assertThat(customerJsonNode.path("externalId").asText()).matches(uuidPattern);
    }
}
