package com.cafe.exception;

import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ExceptionResponse> illegalExceptionHandler(IllegalArgumentException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ExceptionResponse> noElementExceptionHandler(NoSuchElementException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.NO_CONTENT, e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateRequestException.class)
    protected ResponseEntity<ExceptionResponse> duplicateExceptionHandler(DuplicateRequestException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.DUPLICATE_REQUEST, e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
