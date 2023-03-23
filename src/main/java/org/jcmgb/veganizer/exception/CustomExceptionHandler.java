package org.jcmgb.veganizer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {DuplicateValueException.class})
    public ResponseEntity<Object> handleRepeatedValueException(DuplicateValueException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.of("America/Chicago"))
        );

        return new ResponseEntity<>(exception, status);
    }
}