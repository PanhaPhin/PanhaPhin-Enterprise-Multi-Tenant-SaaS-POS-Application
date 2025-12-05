package com.logibytekh.pos.service;

import java.util.List;

import com.logibytekh.pos.modal.User;

public interface UserService {

    User getUserFromJwtToken(String token) throws Exception;
    User getCurrentUser() throws Exception;
    User getUserByEmail(String email) throws Exception;
    User getUserById(Long id) throws Exception;
    List<User> getAllUsers();



    

    
    
}
