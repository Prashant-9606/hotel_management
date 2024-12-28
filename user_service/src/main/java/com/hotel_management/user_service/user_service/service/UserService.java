package com.hotel_management.user_service.user_service.service;

import com.hotel_management.user_service.user_service.entities.User;

import java.util.List;

public interface UserService {

    User postUser(User user);

    List<User> getAllUser();

    User getUserById(String userId);
}
