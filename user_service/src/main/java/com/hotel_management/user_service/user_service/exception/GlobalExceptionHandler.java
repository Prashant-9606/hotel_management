package com.hotel_management.user_service.user_service.exception;


import com.hotel_management.user_service.user_service.entities.ErrorResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponseHandler> handleNoResourceFoundException(Exception e){
        String message = e.getMessage();
        ErrorResponseHandler errorResponseHandler = new ErrorResponseHandler(message, true, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponseHandler, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseHandler> handleResourceNotFoundException(Exception e){
        String message = e.getMessage();
        ErrorResponseHandler errorResponseHandler = new ErrorResponseHandler(message, true, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponseHandler, HttpStatus.NOT_FOUND);
    }
}
