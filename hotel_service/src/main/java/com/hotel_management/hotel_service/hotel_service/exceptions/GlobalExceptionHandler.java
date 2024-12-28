package com.hotel_management.hotel_service.hotel_service.exceptions;


import com.hotel_management.hotel_service.hotel_service.entities.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(Exception e){
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, true, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNoResourceFoundException(Exception e){
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, true, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
