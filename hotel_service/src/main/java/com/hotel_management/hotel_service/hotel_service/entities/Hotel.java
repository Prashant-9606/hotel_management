package com.hotel_management.hotel_service.hotel_service.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {


    @Id
    @Column(name = "hotel_id")
    private String id;

    private String name;

    private String about;

    private String location;

}
