package com.hotel_management.hotel_service.hotel_service.entities;



import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {

    private String message;
    private Boolean success;
    private HttpStatus httpStatus;
}
