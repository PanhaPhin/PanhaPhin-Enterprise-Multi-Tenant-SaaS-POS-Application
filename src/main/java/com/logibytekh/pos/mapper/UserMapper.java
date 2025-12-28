package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User savedUser) {
        if (savedUser == null)
            return null;
        UserDto userDto = new UserDto();

        userDto.setId(savedUser.getId());
        userDto.setFullName(savedUser.getFullName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setRole(savedUser.getRole());
        userDto.setCreatedAt(savedUser.getCreatedAt());
        userDto.setUpdatedAt(savedUser.getUpdatedAt());
        userDto.setLastLogin(savedUser.getLastLogin());
        userDto.setPhone(savedUser.getPhone());
        userDto.setBranchId(savedUser.getBranch()!=null? savedUser.getBranch().getId():null);
        userDto.setStoreId(savedUser.getBranch()!=null?savedUser.getStore().getId():null);


        return userDto;

    }

    public static User toEntity(UserDto userDto) {
        User createdUser = new User();
        createdUser.setEmail(userDto.getEmail());
        createdUser.setFullName(userDto.getFullName());
        createdUser.setRole(userDto.getRole());
        createdUser.setCreatedAt(userDto.getCreatedAt());
        createdUser.setUpdatedAt(userDto.getUpdatedAt());
        createdUser.setPhone(userDto.getPhone());
        createdUser.setPassword(userDto.getPassword());

        return createdUser;

    }

}
