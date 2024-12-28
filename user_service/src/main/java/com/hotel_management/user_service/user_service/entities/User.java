package com.hotel_management.user_service.user_service.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
