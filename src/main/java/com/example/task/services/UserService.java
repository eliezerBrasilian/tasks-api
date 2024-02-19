package com.example.task.services;

import com.example.task.entities.User;
import com.example.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<User> create(User user) {
        User existUser = userRepository.findByUsername(user.getUsername());

        if (existUser != null) {
            throw new Error("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}