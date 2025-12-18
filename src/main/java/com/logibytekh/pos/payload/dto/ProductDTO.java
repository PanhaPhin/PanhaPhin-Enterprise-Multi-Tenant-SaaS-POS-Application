package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Long categoryId;

    
    private Long storeId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

   


    

    
}
