package com.logibytekh.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long>{

    List<Customer> findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String fullName,
            String email
    );


    
    
}
