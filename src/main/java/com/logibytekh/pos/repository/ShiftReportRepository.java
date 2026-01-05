package com.logibytekh.pos.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.ShiftReport;
import com.logibytekh.pos.modal.User;

public interface  ShiftReportRepository extends JpaRepository<ShiftReport, Long> {

    List<ShiftReport> findByCashierId(Long id);

    List<ShiftReport> findByBranchId(Long id);

    ShiftReport findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(User currentUser);

    Optional<ShiftReport> findByCashierAndShiftStartBetween(User cashier, LocalDateTime start, LocalDateTime end);

    
    
}
