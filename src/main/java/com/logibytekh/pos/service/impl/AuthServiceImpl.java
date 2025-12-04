package com.logibytekh.pos.service.impl;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.logibytekh.pos.configuration.JwtProvider;
import com.logibytekh.pos.domain.UserRole;
import com.logibytekh.pos.mapper.UserMapper;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;
import com.logibytekh.pos.payload.response.AuthResponse;
import com.logibytekh.pos.repository.UserRepository;
import com.logibytekh.pos.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomUserImplement customUserImplement;

    @Override
    public AuthResponse signup(UserDto userDto) throws Exception {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            throw new Exception("Email id already registered");

        }
        if (userDto.getRole().equals(UserRole.ROLE_ADMIN)) {
            throw new Exception("role admin is not allowed !");
        }

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(userDto.getRole());
        newUser.setFullName(userDto.getFullName()); // ✅ use fullName, not phone
        newUser.setPhone(userDto.getPhone()); // ✅ set phone separately
        newUser.setLastLogin(LocalDateTime.now());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now()); // ✅ updatedAt instead of calling createdAt twice

        userRepository.save(newUser);

        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDto.getEmail(),
                userDto.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessages("Registerd Successfully ");
        authResponse.setUser(UserMapper.toDto(savedUser));

        return null;
    }

    @SuppressWarnings("unused")
    @Override
    public AuthResponse login(UserDto userDto) throws Exception {
        String email = userDto.getEmail();
        String password = userDto.getPassword();

        Authentication authentication = authenticate(email, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String jwt = jwtProvider.generateToken(authentication);

        String role = authorities.iterator().next().getAuthority();

        User user = userRepository.findByEmail(email);

        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessages("Login Successfully ");
        authResponse.setUser(UserMapper.toDto(user));

        return null;
    }

    private Authentication authenticate(String email, String password) throws Exception {
        UserDetails userDetails = customUserImplement.loadUserByUsername(email);

        if (userDetails == null) {
            throw new Exception("email id doesn't exist " + email);
        }

        // 🔥 Correct password check
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new Exception("password doesn't match");
        }

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities());
    }

}
