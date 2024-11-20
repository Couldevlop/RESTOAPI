package com.resatoAPI.com.exception;

public class OrderItemAlReadyExistException extends RuntimeException{
    private String message;

    public OrderItemAlReadyExistException(String message) {
        this.message = message;
    }

    public OrderItemAlReadyExistException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
