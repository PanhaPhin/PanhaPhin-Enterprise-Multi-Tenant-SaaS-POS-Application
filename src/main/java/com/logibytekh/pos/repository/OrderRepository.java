package com.logibytekh.pos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.modal.User;

public interface  OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBranchId(Long customerId);
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByCashierId(Long cashierId);
    List<Order> findByBranchIdAndCreatedAtBetween(Long branchId, LocalDateTime form, LocalDateTime to);

    List<Order> findByCashierAndCreatedAtBetween(Long cashier,LocalDateTime form, LocalDateTime to);
    
    List<Order> findTop5ByOrderByCreatedAtDesc(Long branchId);
    
}
