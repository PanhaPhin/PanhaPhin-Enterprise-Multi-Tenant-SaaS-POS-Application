package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

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



    @JsonProperty("branch_id")
    private Long branchId;

    @JsonProperty("product_id")
    private Long productId;

    

    private Integer quantity;

    private LocalDateTime lastUpdate;
}
