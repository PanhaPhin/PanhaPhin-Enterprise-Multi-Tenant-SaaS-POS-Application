package com.logibytekh.pos.service;


import java.util.List;

import com.logibytekh.pos.payload.dto.InventoryDTO;

public interface InventoryService {

    InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception;
    
    void deleteInventory(Long id) throws Exception;
    
    InventoryDTO getInventoryById(Long id) throws Exception;

    InventoryDTO getInventoryByProductInAndBranchId(Long productId, Long branchId) throws Exception;
    
    List<InventoryDTO> getAllInventoryByBranchId(Long branchId) throws Exception;
    
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception;
}
