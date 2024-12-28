package com.hotel_management.rating_service.rating_service.controller;


import com.hotel_management.rating_service.rating_service.entities.Rating;
import com.hotel_management.rating_service.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating savedRating = this.ratingService.postRating(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings = this.ratingService.getAllRatings();
        return ResponseEntity.of(Optional.ofNullable(ratings));
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable  String ratingId){
        Rating rating = this.ratingService.getRatingById(ratingId);


        return new ResponseEntity<>(rating, HttpStatus.FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> ratingsByUser(@PathVariable String userId){
        List<Rating> userRatings = this.ratingService.getRatingByUser(userId);
        return new ResponseEntity<>(userRatings, HttpStatus.FOUND);
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Rating>> ratingsOnHotel(@PathVariable String hotelId){
        List<Rating> hotelRatings = this.ratingService.getRatingByHotel(hotelId);
        return new ResponseEntity<>(hotelRatings, HttpStatus.FOUND);
    }

//    @PutMapping("hotel/{hotelId}")
//    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId){
//
//    }
}
