package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

    private Long id;

    private BranchDTO branch;

    private Long branchId;
    
    private Long productId;

    private ProductDTO product;

    private Integer quantity;

    private LocalDateTime lastUpdate;
}
