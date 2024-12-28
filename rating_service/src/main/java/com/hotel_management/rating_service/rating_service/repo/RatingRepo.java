package com.hotel_management.rating_service.rating_service.repo;

import com.hotel_management.rating_service.rating_service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating, String> {

    List<Rating> getByUserId(String userId);

    List<Rating> getByHotelId(String hotelId);

}
