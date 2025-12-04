package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.logibytekh.pos.domain.UserRole;


import lombok.Data;

@Data
public class UserDto {

    private Long id;

    
    private String fullName;

    private String email;

    private String phone;


    private String password;
    
    private UserRole role;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;
    
}
