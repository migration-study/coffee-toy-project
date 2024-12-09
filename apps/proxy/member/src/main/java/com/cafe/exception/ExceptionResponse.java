package com.cafe.exception;

public class ExceptionResponse {
    private final String type;
    private final String message;

    public ExceptionResponse(String type, String message) {
        this.type = type;
        this.message = message;

        printExceptionMessage();
    }

    public void printExceptionMessage() {
        System.out.println("******** Exception ********");
        System.out.println("type : "+type);
        System.out.println("message : "+message);
    }
}
