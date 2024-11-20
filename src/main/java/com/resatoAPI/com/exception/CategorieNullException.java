package com.resatoAPI.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class CategorieNullException extends RuntimeException{
    private String message;

    public CategorieNullException(String message) {
        this.message = message;
    }

    public CategorieNullException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
