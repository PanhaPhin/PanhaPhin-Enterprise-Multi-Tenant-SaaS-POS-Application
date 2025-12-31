package com.logibytekh.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.modal.User;

public interface  OrderRespository extends JpaRepository<Order, Long> {
    List<Order> findByBranchId(Long customerId);
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByCashierId(Long cashierId);
    List<Order> findByBranchIdAndCreatedAtBetween(Long branchId, LocalDateTime form, LocalDateTime to);

    List<Order> findByCreatedAtBetween(User cashier,LocalDateTime form, LocalDateTime to);
    
    List<Order> findTop5ByOrderByCreatedAtDesc(Long branchId);
    
}
