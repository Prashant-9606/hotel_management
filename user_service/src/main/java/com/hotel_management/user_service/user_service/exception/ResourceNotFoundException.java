package com.hotel_management.user_service.user_service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Resource not available");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
