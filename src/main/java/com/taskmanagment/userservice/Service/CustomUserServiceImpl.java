package com.taskmanagment.userservice.Service;

import com.taskmanagment.userservice.Repository.UserRepository;
import com.taskmanagment.userservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(username);
        if(users==null){
            throw new UsernameNotFoundException("User not found with email "+username);

        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        return new User(users.getEmail(),users.getPassword(),grantedAuthorities);
    }
}
