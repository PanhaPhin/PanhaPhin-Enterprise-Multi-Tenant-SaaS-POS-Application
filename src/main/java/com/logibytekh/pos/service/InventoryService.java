package com.logibytekh.pos.service;


import java.util.List;

import com.logibytekh.pos.payload.dto.InventoryDTO;

public interface  InventoryService {

    InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception;
    InventoryDTO updateInventory (InventoryDTO inventoryDTO) throws Exception;
    void deleteInventory(Long id);
    InventoryDTO getInventoryById(Long id);
    InventoryDTO getInventoryByProductInAndBranchId(Long productId , Long branchId);
    List<InventoryDTO> getAllInventoryByBranchId(Long branchId);
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception;






    
}
