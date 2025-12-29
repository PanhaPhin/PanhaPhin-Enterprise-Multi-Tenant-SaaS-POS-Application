package com.logibytekh.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Customer;
import java.util.List;



public interface CustomerRespository extends JpaRepository<Customer, Long>{

    List<Customer> findbyFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
        String fullName , String email
    );
    
}
