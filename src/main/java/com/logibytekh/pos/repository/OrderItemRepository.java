package com.logibytekh.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.payload.dto.OrderitemDTO;

public interface OrderItemRepository extends JpaRepository<OrderitemDTO , Long>{

    
    
}
