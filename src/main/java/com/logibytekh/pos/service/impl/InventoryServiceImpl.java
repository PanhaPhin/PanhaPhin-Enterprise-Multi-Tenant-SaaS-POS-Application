package com.logibytekh.pos.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.payload.dto.InventoryDTO;
import com.logibytekh.pos.repository.InventoryRespository;
import com.logibytekh.pos.repository.ProductRespository;
import com.logibytekh.pos.service.InventoryService;


import com.logibytekh.pos.modal.Product;

import lombok.RequiredArgsConstructor;

import com.logibytekh.pos.mapper.InventoryMapper;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Inventory;
import com.logibytekh.pos.repository.BranchRespository;



@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRespository inventoryRespository;
    private final BranchRespository branchRepository;
    private final ProductRespository productRespository;
   

    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) throws Exception {
       Branch branch = branchRepository.findById(inventoryDTO.getBranchId())
               .orElseThrow(() -> new Exception("Branch not found with id: ")
            
            );
            Product product = productRespository.findById(inventoryDTO.getProductId())
               .orElseThrow(() -> new Exception("Product not found with id: ")
            
            );

            Inventory inventory = InventoryMapper.toEntity(inventoryDTO, branch, product);
            Inventory savedInventory = inventoryRespository.save(inventory);
            return InventoryMapper.toDTO(savedInventory);
            

    }

    @Override
    public void deleteInventory(Long id) throws Exception {
       Inventory inventory = inventoryRespository.findById(id)
               .orElseThrow(() -> new Exception("Inventory not found with id: ")
            
            );
            inventoryRespository.delete(inventory);
    }

    @Override
    public InventoryDTO getInventoryById(Long id) throws Exception {
       Inventory inventory = inventoryRespository.findById(id)
               .orElseThrow(() -> new Exception("Inventory not found with id: ")
            
            );
            return InventoryMapper.toDTO(inventory);
    }

    @Override
    public InventoryDTO getInventoryByProductInAndBranchId(Long productId, Long branchId) {
         Inventory inventory = inventoryRespository.findByBranchIdAndProductId(productId, branchId);
            
            return InventoryMapper.toDTO(inventory);
    }

    @Override
    public List<InventoryDTO> getAllInventoryByBranchId(Long branchId) {
       List<Inventory> inventories = inventoryRespository.findByBranchId(branchId);
            return inventories.stream().map(
                InventoryMapper::toDTO
            ).collect(Collectors.toList());
        }
    
                    

    @Override
    public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) throws Exception {
       Inventory inventory = inventoryRespository.findById(id)
               .orElseThrow(() -> new Exception("Inventory not found with id: ")
            
            );
            inventory.setQuantity(inventoryDTO.getQuantity());
            Inventory updatedInventory = inventoryRespository.save(inventory);
            return InventoryMapper.toDTO(updatedInventory);

    }
    
}
