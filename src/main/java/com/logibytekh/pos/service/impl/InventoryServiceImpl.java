package com.logibytekh.pos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.payload.dto.InventoryDTO;
import com.logibytekh.pos.repository.BranchRespository;
import com.logibytekh.pos.repository.InventoryRespository;
import com.logibytekh.pos.repository.ProductRespository;
import com.logibytekh.pos.service.InventoryService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRespository inventoryRespository;
    private final BranchRespository branchRespoitory;
    private final ProductRespository productRespository;

    
    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception {

        Branch exiting = branchRespoitory.findById(inventoryDTO.getBranchId()).orElseThrow(
            ()-> new Exception ("branch not exist...")

        );
        Product product = productRespository.findById(inventoryDTO.getProductId())
            .orElseThrow(
                ()-> new Exception("product not exist...")


            );
            

        return null;
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteInventory(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InventoryDTO getInventoryById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InventoryDTO getInventoryByProductInAndBranchId(Long productId, Long branchId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<InventoryDTO> getAllInventoryByBranchId(Long branchId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
