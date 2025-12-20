package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.logibytekh.pos.modal.Category;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String sku;

    private String description;

    @NotNull
    private Double mrp;

    @NotNull
    private Double sellingPrice;

    private String brand;

    private String image;

    private Category category;
    private Long categoryId;
    private Long storeId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
}
