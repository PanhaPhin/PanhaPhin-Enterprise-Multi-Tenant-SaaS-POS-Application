package com.logibytekh.pos.mapper;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User savedUser){
        UserDto userDto = new UserDto();
        
        userDto.setId(savedUser.getId());
        userDto.setEmail(savedUser.getEmail());
        userDto.setRole(savedUser.getRole());
        userDto.setCreatedAt(savedUser.getCreatedAt());
        userDto.setUpdatedAt(savedUser.getUpdatedAt());
        userDto.setLastLogin(savedUser.getLastLogin());
        userDto.setPhone(savedUser.getPhone());
    

        return userDto;
        
        
    }
    
}
