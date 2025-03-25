package com.project.Booking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleBookNotFoundException(BookNotFoundException ex){
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date()
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
