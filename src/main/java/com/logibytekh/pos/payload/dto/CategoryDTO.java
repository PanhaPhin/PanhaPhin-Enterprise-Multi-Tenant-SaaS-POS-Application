package com.logibytekh.pos.payload.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CategoryDTO {

    private Long id;

    private String name;

    @NotNull
    private String description;

    // Store ID only, no full Store entity
    private Long storeId;
}
