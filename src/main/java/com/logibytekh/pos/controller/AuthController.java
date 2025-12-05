package com.logibytekh.pos.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.UserDto;
import com.logibytekh.pos.payload.response.AuthResponse;
import com.logibytekh.pos.service.AuthService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    // http://localhost:8080/


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signupHandler(
        @RequestBody UserDto userDto
        
    ) throws Exception{
        return ResponseEntity.ok(
            authService.signup(userDto)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginHandler(
        @RequestBody UserDto userDto
        
    ) throws Exception{
        return ResponseEntity.ok(
            authService.login(userDto)
        );
    }


    
}
