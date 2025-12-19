package com.logibytekh.pos.payload.dto;


import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDTO {

    
    private Long id;

   
    private String name;


    
    private String sku;

    private String description;

    private Double mrp;

    private Double sellingPrice;
    private String brand;
    private String image;

    // private Category category

    private CategoryDTO category;

    private Long categoryId;

    
    private Long storeId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

   


    

    
}
