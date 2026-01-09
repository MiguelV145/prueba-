package com.company.vehicles.Exception.domain;

import org.springframework.http.HttpStatus;

import com.company.vehicles.Exception.base.ApplicationException;

public class BadRequestException extends ApplicationException {
     public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message)   ;}
}
