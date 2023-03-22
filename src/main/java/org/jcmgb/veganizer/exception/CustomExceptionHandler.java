package com.shortenlinkapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {DuplicateValueException.class})
    public ResponseEntity<Object> handleRepeatedValueException(DuplicateValueException e) {
        DuplicateValueException linkShortenerException = new DuplicateValueException(
                e.getMessage()
        );

        return new ResponseEntity<>(linkShortenerException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}