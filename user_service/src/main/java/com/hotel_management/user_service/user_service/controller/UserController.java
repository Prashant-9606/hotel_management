package com.hotel_management.user_service.user_service.controller;



import com.hotel_management.user_service.user_service.entities.User;
import com.hotel_management.user_service.user_service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = this.userService.postUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "handleServiceDownSituation")
    public ResponseEntity<User> fetchUserById(@PathVariable String userId){
        User userDto = this.userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


    public ResponseEntity<User> handleServiceDownSituation(String userId, Exception e){
        User user = User.builder().id("401").about("Error occurred because some service is down").email("dummy@gmail.com").build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
