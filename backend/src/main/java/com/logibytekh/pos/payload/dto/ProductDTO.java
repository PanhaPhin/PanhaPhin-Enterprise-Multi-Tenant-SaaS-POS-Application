package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    
    private String name;;

    private String sku;

    private String description;

    private Double mrp;

    @JsonProperty("selling_price")
    @NotNull
    private Double sellingPrice;

    private String brand;

    private String image;

    // private Category category

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("store_id")
    private Long storeId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
