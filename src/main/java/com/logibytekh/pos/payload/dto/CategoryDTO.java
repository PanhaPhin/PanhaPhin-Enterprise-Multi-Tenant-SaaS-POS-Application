package com.logibytekh.pos.payload.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    private String name;

    private String description;

    // Store ID only, no full Store entity
    private Long storeId;
}
