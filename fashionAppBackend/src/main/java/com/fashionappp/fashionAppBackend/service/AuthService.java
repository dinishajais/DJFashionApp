package com.fashionappp.fashionAppBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fashionappp.fashionAppBackend.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> password.equals(user.getPassword()))
                .orElse(false);
    }
}
