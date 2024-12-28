package com.hotel_management.rating_service.rating_service.service.impl;


import com.hotel_management.rating_service.rating_service.entities.Rating;
import com.hotel_management.rating_service.rating_service.exception.ResourceNotFoundException;
import com.hotel_management.rating_service.rating_service.repo.RatingRepo;
import com.hotel_management.rating_service.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Rating postRating(Rating rating) {
        String randomRatingId = UUID.randomUUID().toString();
        rating.setId(randomRatingId);
        return this.ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingRepo.findAll();
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return this.ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating details not found with id :"+ ratingId));
    }

    @Override
    public List<Rating> getRatingByUser(String userId) {
        return this.ratingRepo.getByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return this.ratingRepo.getByHotelId(hotelId);
    }
}
