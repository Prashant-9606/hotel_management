package com.hotel_management.hotel_service.hotel_service.controller;


import com.hotel_management.hotel_service.hotel_service.entities.Hotel;
import com.hotel_management.hotel_service.hotel_service.services.HotelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = this.hotelService.postHotel(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotelList = this.hotelService.getAllHotels();
        return ResponseEntity.of(Optional.ofNullable(hotelList));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel hotel = this.hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }
}
