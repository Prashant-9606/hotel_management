package com.hotel_management.rating_service.rating_service.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rating")
@Getter
@Setter
@NoArgsConstructor

public class Rating {

    @Id
    private String Id;

    private String userId;

    private String hotelId;

    private Integer rating;

    private String feedback;
}
