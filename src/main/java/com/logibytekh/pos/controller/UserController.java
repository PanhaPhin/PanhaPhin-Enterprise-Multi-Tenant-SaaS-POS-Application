package com.logibytekh.pos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.mapper.UserMapper;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

  @GetMapping("/profile")
public ResponseEntity<UserDto> getUserProfile(
        @RequestHeader("Authorization") String jwt) throws Exception {

    if (jwt == null || jwt.isBlank()) {
        return ResponseEntity.status(401).build();
    }

    // FIX: clean token, remove hidden Unicode characters
    String token = jwt.replace("Bearer", "")
                      .replace("bearer", "")
                      .trim()
                      .replace("\uFEFF", "") // remove BOM
                      .replace("\u200B", ""); // remove zero-width space

    User user = userService.getUserFromJwtToken(token);

    if (user == null) {
        return ResponseEntity.status(401).build();
    }

    return ResponseEntity.ok(UserMapper.toDto(user));
}


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id) throws Exception {

        User user = userService.getUserById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }
}

