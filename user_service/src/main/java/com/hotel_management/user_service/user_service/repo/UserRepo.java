package com.hotel_management.user_service.user_service.repo;


import com.hotel_management.user_service.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
