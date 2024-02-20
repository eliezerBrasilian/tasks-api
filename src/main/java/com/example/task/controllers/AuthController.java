package com.example.task.controllers;

import com.example.task.dtos.AuthDTO;
import com.example.task.dtos.RegisterDTO;
import com.example.task.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks/v1/auth")
public class AuthController {

    @Autowired
    AuthService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthDTO authetinticationDto) {
        return authorizationService.login(authetinticationDto);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDto) {
        return authorizationService.register(registerDto);
    }
}