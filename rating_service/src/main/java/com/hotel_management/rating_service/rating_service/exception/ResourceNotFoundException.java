package com.hotel_management.rating_service.rating_service.exception;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(){
        super("Rating details not available");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
