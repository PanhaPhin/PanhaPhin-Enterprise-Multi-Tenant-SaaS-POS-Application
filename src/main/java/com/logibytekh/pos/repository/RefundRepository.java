package com.logibytekh.pos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Refund;
import com.logibytekh.pos.modal.User;

public interface  RefundRepository extends JpaRepository<Refund, Long>{

    List<Refund> findByCashierIdAndCreatedAtBetween(Long cashier, LocalDateTime from, LocalDateTime to);

    List<Refund> findByCashierId(Long cashierId);
    List<Refund> findByShiftReportId(Long shiftReportId);
    List<Refund> findByBranchId(Long branchId);

    
}
