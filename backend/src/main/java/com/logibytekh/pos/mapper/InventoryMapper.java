package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Inventory;
import com.logibytekh.pos.payload.dto.InventoryDTO;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Product;

public class InventoryMapper {

    public static InventoryDTO toDTO(Inventory inventory) {
        if (inventory == null)
            return null;

        return InventoryDTO.builder()
                .id(inventory.getId())
                .branchId(inventory.getBranch() != null ? inventory.getBranch().getId() : null)
                .productId(inventory.getProduct() != null ? inventory.getProduct().getId() : null)
                .quantity(inventory.getQuantity())
                .lastUpdate(inventory.getLastUpdate())
                .build();
    }

    // Convert DTO → Inventory entity
    public static Inventory toEntity(InventoryDTO inventoryDTO, Branch branch, Product product) {
        if (inventoryDTO == null)
            return null;

        return Inventory.builder()
                .branch(branch)
                .product(product)
                .quantity(inventoryDTO.getQuantity())
                .build();
    }
}