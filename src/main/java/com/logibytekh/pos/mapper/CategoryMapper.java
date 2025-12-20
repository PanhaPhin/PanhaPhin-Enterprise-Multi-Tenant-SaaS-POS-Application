package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Category;
import com.logibytekh.pos.payload.dto.CategoryDTO;
import com.logibytekh.pos.modal.Store;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category){
         if (category == null) return null;

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .storeId(category.getStore()!= null?category.getStore().getId():null)
                .build();
    }
                
        public static Category toEntity(CategoryDTO categoryDTO){
            if (categoryDTO = null){
                return null;
        }
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
                

    }
    
}
