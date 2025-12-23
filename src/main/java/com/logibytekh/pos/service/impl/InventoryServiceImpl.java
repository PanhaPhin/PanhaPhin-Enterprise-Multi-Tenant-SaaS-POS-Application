package com.logibytekh.pos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.mapper.InventoryMapper;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Inventory;
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

            Inventory inventory = InventoryMapper.toEntity(inventoryDTO, exiting, product);
            Inventory savedInventory = inventoryRespository.save(inventory);
            return InventoryMapper.toDTO(savedInventory);
            

      
    }


    @Override
public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception {

    Inventory inventory = inventoryRespository.findById(id)
            .orElseThrow(() -> new Exception("Inventory not found")
    
        );


    inventory.setQuantity(inventoryDTO.getQuantity());

    Inventory updatedInventory = inventoryRespository.save(inventory);
    return InventoryMapper.toDTO(updatedInventory);
}




    @Override
    public void deleteInventory(Long id) throws Exception {
        Inventory inventory = inventoryRespository.findById(id)
            .orElseThrow(() -> new Exception("Inventory not found")
    
        );
        inventoryRespository.delete(inventory);
      
      
    }

    @Override
    public InventoryDTO getInventoryById(Long id) throws Exception {
         Inventory inventory = inventoryRespository.findById(id)
            .orElseThrow(() -> new Exception("Inventory not found")
    
        );
        return InventoryMapper.toDTO(inventory);
    }

    @Override
    public InventoryDTO getInventoryByProductInAndBranchId(Long productId, Long branchId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<InventoryDTO> getAllInventoryByBranchId(Long branchId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
