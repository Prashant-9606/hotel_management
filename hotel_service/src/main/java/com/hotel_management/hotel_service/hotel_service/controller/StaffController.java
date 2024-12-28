package com.hotel_management.hotel_service.hotel_service.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {


    @GetMapping
    public ResponseEntity<List<String>> allStaffs(){
        List<String> staffs =  Arrays.asList("Jocy","Hari", "Sivamani", "Ganapathy");
        return new ResponseEntity<>(staffs, HttpStatus.OK);

    }
}
