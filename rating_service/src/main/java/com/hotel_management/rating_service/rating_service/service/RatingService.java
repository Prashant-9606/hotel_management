package com.hotel_management.rating_service.rating_service.service;

import com.hotel_management.rating_service.rating_service.entities.Rating;

import java.util.List;

public interface RatingService {


    Rating postRating(Rating rating);

    List<Rating> getAllRatings();

    Rating getRatingById(String ratingId);

    List<Rating> getRatingByUser(String userId);

    List<Rating> getRatingByHotel(String hotelId);
}
