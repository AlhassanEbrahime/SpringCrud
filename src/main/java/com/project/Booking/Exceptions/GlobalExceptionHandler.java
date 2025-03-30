package com.project.Booking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex)
    {
        Map<String, String > errors = new HashMap<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date()
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


}
