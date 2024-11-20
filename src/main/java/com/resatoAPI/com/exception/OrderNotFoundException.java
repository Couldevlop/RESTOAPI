package com.resatoAPI.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException{
    private String message;

    public OrderNotFoundException(String message) {
        this.message = message;
    }

    public OrderNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
