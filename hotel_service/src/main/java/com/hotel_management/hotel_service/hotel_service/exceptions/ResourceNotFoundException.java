package com.hotel_management.hotel_service.hotel_service.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String message){
        super(message);;
    }
}
