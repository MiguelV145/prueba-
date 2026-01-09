package com.company.vehicles.Exception.base;

import org.springframework.http.HttpStatus;

public class ApplicationException {
        private final HttpStatus status;

    protected ApplicationException(HttpStatus status, String message) {
        super();
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
}
