package com.logibytekh.pos.payload.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class CategoryDTO {

    private Long id;

    private String name;

    private String description;

    // Store ID only, no full Store entity
    private Long storeId;
}
