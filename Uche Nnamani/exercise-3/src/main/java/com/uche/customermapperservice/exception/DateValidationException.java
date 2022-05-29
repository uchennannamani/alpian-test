package com.uche.customermapperservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Input date is not valid.")
public class DateValidationException extends Exception {

//    private static final long serialVersionUID = 1L;

    public DateValidationException(String errorMessage) {
        super(errorMessage);
    }
}
