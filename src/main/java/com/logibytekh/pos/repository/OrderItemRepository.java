package com.logibytekh.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

    
    
}
