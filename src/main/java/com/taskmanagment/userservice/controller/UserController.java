package com.taskmanagment.userservice.controller;

import com.taskmanagment.userservice.Service.UserService;
import com.taskmanagment.userservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<Users> getUserProfile(@RequestHeader("Authorization") String authHeader) {
        // Ensure token starts with "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Extract JWT token (remove "Bearer " prefix)
        String jwt = authHeader.substring(7);

        // Fetch user profile using token
        Users users = userService.getUserProfile(jwt);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
