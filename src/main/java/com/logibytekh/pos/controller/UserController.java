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
            @RequestHeader(value = "Authorization", required = false) String jwt) throws Exception {

        if (jwt == null || jwt.isBlank()) {
            System.out.println("Authorization header is missing or blank");
            return ResponseEntity.status(401).build();
        }

        // Clean token: remove "Bearer ", whitespace, BOM, zero-width spaces
        String token = jwt.replaceFirst("(?i)Bearer ", "") // case-insensitive remove "Bearer "
                          .trim()
                          .replace("\uFEFF", "")
                          .replace("\u200B", "");

        System.out.println("Token after cleaning: '" + token + "'");

        // Extract user from JWT
        User user;
        try {
            user = userService.getUserFromJwtToken(token);
        } catch (Exception e) {
            System.out.println("Failed to parse JWT: " + e.getMessage());
            return ResponseEntity.status(401).build();
        }

        if (user == null) {
            System.out.println("JWT token invalid or user not found for token: " + token);
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    /**
     * Get a user by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(
            @RequestHeader(value = "Authorization", required = false) String jwt,
            @PathVariable Long id) throws Exception {

        if (jwt == null || jwt.isBlank()) {
            System.out.println("Authorization header is missing or blank");
            return ResponseEntity.status(401).build();
        }

        // Optional: you could also verify JWT for /{id} access if needed
        String token = jwt.replaceFirst("(?i)Bearer ", "").trim();

        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(UserMapper.toDto(user));
    }
}

