package com.logibytekh.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.User;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    
}
