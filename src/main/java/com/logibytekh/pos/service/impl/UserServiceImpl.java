package com.logibytekh.pos.service.impl;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.logibytekh.pos.configuration.JwtProvider;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.repository.UserRepository;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User getUserFromJwtToken(String token) throws Exception {
       String email = jwtProvider.getEmailFromToken(token);
       User user = userRepository.findByEmail(email);
       if(user==null){
        throw new Exception("Invalid token");

       }
       return null;
    }

    @Override
    public User getCurrentUser() throws Exception {
        String email=SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("user not found ");
        }
        return user;
       
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("user not found ");
        }
        return user;
       
    }

    @Override
    public User getUserById(Long id) {
       return userRepository.findById(id).orElse(null);

        
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
      
    }

    
}
