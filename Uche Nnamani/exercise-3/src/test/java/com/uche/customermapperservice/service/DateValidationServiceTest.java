package com.uche.customermapperservice.service;

import com.uche.customermapperservice.CustomerMapperServiceApplication;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = CustomerMapperServiceApplication.class)
class DateValidationServiceTest {

    @Autowired
    private DateValidationService dateValidationService;

    @Test
    @DisplayName("Validating dates in the future. DateValidationService should result to 'true' for dates in the future")
    @Order(1)
    void isDateInTheFutureTest_1() {
        assertTrue(dateValidationService.isDateInTheFuture(LocalDate.now().plusDays(1)));
        assertTrue(dateValidationService.isDateInTheFuture(LocalDate.now().plusWeeks(1)));
        assertTrue(dateValidationService.isDateInTheFuture(LocalDate.now().plusMonths(1)));
        assertTrue(dateValidationService.isDateInTheFuture(LocalDate.now().plusYears(1)));
    }

    @Test
    @DisplayName("Validating dates in the past. DateValidationService will result to 'false' for dates in the past")
    @Order(2)
    void isDateInTheFutureTest_2() {
        assertFalse(dateValidationService.isDateInTheFuture(LocalDate.now().minusDays(1)));
        assertFalse(dateValidationService.isDateInTheFuture(LocalDate.now().minusWeeks(1)));
        assertFalse(dateValidationService.isDateInTheFuture(LocalDate.now().minusMonths(1)));
        assertFalse(dateValidationService.isDateInTheFuture(LocalDate.now().minusYears(1)));
    }

    @Test
    @DisplayName("Validating today's date. DateValidationService will result to 'false' for today's date")
    @Order(3)
    void isDateInTheFutureTest_3() {
        assertFalse(dateValidationService.isDateInTheFuture(LocalDate.now()));
    }
}