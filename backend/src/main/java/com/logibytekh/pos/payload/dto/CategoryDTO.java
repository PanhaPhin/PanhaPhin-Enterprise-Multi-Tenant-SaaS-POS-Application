package com.logibytekh.pos.payload.dto;


import lombok.Data;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    private String name;

    
    private String description;

    private Long storeId;
}