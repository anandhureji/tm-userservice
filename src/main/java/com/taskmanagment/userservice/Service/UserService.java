package com.taskmanagment.userservice.Service;

import com.taskmanagment.userservice.model.Users;
import org.apache.catalina.User;

public interface UserService {

    public Users getUserProfile(String jwt);
}
