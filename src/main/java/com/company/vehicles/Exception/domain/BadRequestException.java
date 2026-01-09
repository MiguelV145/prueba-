package com.company.vehicles.Exception.domain;

import org.springframework.http.HttpStatus;

public class BadRequestException {
     public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }    
}
