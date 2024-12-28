package com.hotel_management.hotel_service.hotel_service.repo;

import com.hotel_management.hotel_service.hotel_service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String> {
}
