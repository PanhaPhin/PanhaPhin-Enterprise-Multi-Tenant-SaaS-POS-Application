package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Category;
import com.logibytekh.pos.payload.dto.CategoryDTO;


public class CategoryMapper {
    public static CategoryDTO toDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .storeId(category.getStore()!= null?category.getStore().getId():null)
                .build();     
    }
  
}
