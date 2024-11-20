package com.resatoAPI.com.exception;

public class CategoryAlReadyExistException extends RuntimeException{
    private String message;

    public CategoryAlReadyExistException(String message) {
        this.message = message;
    }

    public CategoryAlReadyExistException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
