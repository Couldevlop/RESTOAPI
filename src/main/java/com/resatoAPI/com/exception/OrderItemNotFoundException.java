package com.resatoAPI.com.exception;

public class OrderItemNotFoundException extends RuntimeException{
    private String message;

    public OrderItemNotFoundException(String message) {
        this.message = message;
    }

    public OrderItemNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
