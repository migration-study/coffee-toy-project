package com.example;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException() {
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
