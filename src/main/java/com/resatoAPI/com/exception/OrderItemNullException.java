package com.resatoAPI.com.exception;

public class OrderItemNullException extends RuntimeException{
    private String mesage;

    public OrderItemNullException(String mesage) {
        this.mesage = mesage;
    }

    public OrderItemNullException(String message, String mesage) {
        super(message);
        this.mesage = mesage;
    }
}
