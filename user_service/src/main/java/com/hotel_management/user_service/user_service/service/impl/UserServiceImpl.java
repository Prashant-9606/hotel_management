package com.hotel_management.user_service.user_service.service.impl;


import com.hotel_management.user_service.user_service.entities.Hotel;
import com.hotel_management.user_service.user_service.entities.Rating;
import com.hotel_management.user_service.user_service.entities.User;
import com.hotel_management.user_service.user_service.external.services.HotelService;
import com.hotel_management.user_service.user_service.repo.UserRepo;
import com.hotel_management.user_service.user_service.service.UserService;
import com.hotel_management.user_service.user_service.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HotelService hotelService;

    @Override
    public User postUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setId(randomUserId);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = this.userRepo.findAll();
        userList.forEach(user -> {
            Rating[] userRatingsArray = this.restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getId(), Rating[].class);

            assert userRatingsArray != null;
            List<Rating> userRatings = Arrays.stream(userRatingsArray).toList();

            userRatings.forEach(rating -> {
//                ResponseEntity<Hotel> ratedHotelResponse   = this.restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
                Hotel ratedHotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(ratedHotel);
            });


            user.setRatings(userRatings);

        });
        return userList;
    }


    @Override
    public User getUserById(String userId) {
        //Fetch User from db
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Details not available for id :"+ userId));

        //Rest call to fetch all ratings from rating service and storing into Rating array
        Rating[] userRatingsArray = restTemplate.getForObject(
                "http://RATING-SERVICE/rating/user/" + user.getId(),
                Rating[].class
        );

        //Conversion of Rating[] array into List
        assert userRatingsArray != null;
        List<Rating> userRatings = Arrays.stream(userRatingsArray).toList();

        //Parsing rating List and setting hotel details
        userRatings.forEach(rating -> {
            ResponseEntity<Hotel> ratedHotelResponse   = this.restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel ratedHotel = ratedHotelResponse.getBody();
            rating.setHotel(ratedHotel);
        });

        //After getting ratings and hotels setting it into user
        user.setRatings(userRatings);
        return  user;
    }


}
