package com.uche.customermapperservice.service;

import com.uche.customermapperservice.exception.DateValidationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class DateValidationService {

    public boolean isDateInTheFuture(LocalDate inputDate) throws DateValidationException {

        LocalDate currentDate = LocalDate.now();
        return inputDate.isAfter(currentDate);
    }
}
