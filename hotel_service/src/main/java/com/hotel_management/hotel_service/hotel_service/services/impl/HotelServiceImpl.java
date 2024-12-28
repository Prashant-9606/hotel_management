package com.hotel_management.hotel_service.hotel_service.services.impl;

import com.hotel_management.hotel_service.hotel_service.entities.Hotel;
import com.hotel_management.hotel_service.hotel_service.exceptions.ResourceNotFoundException;
import com.hotel_management.hotel_service.hotel_service.repo.HotelRepo;
import com.hotel_management.hotel_service.hotel_service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel postHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return this.hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel Details not available for id :"+hotelId));
    }
}
