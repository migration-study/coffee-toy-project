package com.cafe.exception;

import lombok.Setter;

public class ExceptionResponse {
    private final int status;
    private final String message;

    public ExceptionResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }

    public ExceptionResponse(ErrorCode errorCode, String detail) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();

        printExceptionMessage(detail);
    }

    public void printExceptionMessage(String detail) {
        System.out.println("******** Exception ********");
        System.out.println("status : " + status);
        System.out.println("message : " + message);
        System.out.println("detail : " + detail);
    }
}
