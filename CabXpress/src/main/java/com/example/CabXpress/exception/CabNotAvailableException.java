package com.example.CabXpress.exception;

public class CabNotAvailableException extends RuntimeException{

    public CabNotAvailableException(String message) {
        super(message);
    }
}
