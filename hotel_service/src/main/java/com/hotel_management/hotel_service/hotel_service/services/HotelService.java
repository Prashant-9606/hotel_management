package com.hotel_management.hotel_service.hotel_service.services;

import com.hotel_management.hotel_service.hotel_service.entities.Hotel;

import java.util.List;

public interface HotelService {


    Hotel postHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String hotelId);
}
