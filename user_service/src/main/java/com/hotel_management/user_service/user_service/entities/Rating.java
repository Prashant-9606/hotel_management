package com.hotel_management.user_service.user_service.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String id;

    private String userId;

    private String hotelId;

    private Integer rating;

    private String feedback;

    private Hotel hotel;
}
