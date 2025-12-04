package com.logibytekh.pos.payload.response;

import com.logibytekh.pos.payload.dto.UserDto;

import lombok.Data;


@Data
public class AuthResponse {
    private String jwt;
    private String messages;
    private UserDto user; 
    
}
