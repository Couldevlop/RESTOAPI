package com.resatoAPI.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DishNotFoundException extends RuntimeException{
    private String message;

    public DishNotFoundException(String message) {
        this.message = message;
    }

    public DishNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
