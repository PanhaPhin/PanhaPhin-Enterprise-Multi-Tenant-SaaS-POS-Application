package com.logibytekh.pos.service;

import com.logibytekh.pos.payload.dto.UserDto;
import com.logibytekh.pos.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse signup(UserDto userDto) throws Exception;
    AuthResponse login(UserDto userDto) throws Exception;
    
    

    
}
