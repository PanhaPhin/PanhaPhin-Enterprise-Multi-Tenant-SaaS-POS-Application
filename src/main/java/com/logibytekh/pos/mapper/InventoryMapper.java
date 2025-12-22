package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Inventory;
import com.logibytekh.pos.payload.dto.InventoryDTO;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Product;

public class InventoryMapper {

    public static InventoryDTO toDTO(Inventory inventory) {
        return InventoryDTO.builder()
                .id(inventory.getId())
                .branchId(inventory.getBranch().getId())
                .productId(inventory.getProduct().getId())
                .product(ProductMapper.toDto(inventory.getProduct()))
                .quantity(inventory.getQuantity())
                .build();

    }

    public static Inventory toEntity(InventoryDTO inventoryDTO, Branch branch, Product product) {



        return Inventory.builder()
                .branch(branch)
                .product(product)
                .quantity(inventoryDTO.getQuantity())
                .build();
    }
    
}
