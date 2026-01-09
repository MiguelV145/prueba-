package com.company.vehicles.Exception.domain;

import org.springframework.http.HttpStatus;

import com.company.vehicles.Exception.base.ApplicationException;

public class ConflictException extends ApplicationException{
    
    public ConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
