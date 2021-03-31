package com.luxoft.springaop.lab5.exeption;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

}
