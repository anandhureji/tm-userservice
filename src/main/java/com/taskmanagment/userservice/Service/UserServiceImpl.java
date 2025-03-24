package com.taskmanagment.userservice.Service;

import com.taskmanagment.userservice.Repository.UserRepository;
import com.taskmanagment.userservice.config.JwtProvider;
import com.taskmanagment.userservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users getUserProfile(String jwt) {
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        return userRepository.findByEmail(email);

    }
}
