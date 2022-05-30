package com.uche.customermapperservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateValidationService {

    public boolean isDateInTheFuture(LocalDate inputDate) {

        LocalDate currentDate = LocalDate.now();
        return inputDate.isAfter(currentDate);
    }
}
