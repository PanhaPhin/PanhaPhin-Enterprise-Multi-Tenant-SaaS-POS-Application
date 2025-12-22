package com.logibytekh.pos.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Inventory;


public interface  InventoryRespository extends JpaRepository <Inventory, Long> {

    Inventory findByBranchIdAndProductId(Long branchId, Long productId);
    List<Inventory> findByBranchId(Long branchId);
    
}
