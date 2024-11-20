package com.resatoAPI.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DishAlReadyException extends RuntimeException{
    private String message;

    public DishAlReadyException(String message) {
        this.message = message;
    }

    public DishAlReadyException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
