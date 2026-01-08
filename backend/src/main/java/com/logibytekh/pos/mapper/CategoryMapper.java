package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Category;
import com.logibytekh.pos.payload.dto.CategoryDTO;


public class CategoryMapper {

    private CategoryMapper() {}

    public static CategoryDTO toDTO(Category category) {
        if (category == null) return null;

        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
       

        if (category.getStore() != null) {
            dto.setStoreId(category.getStore().getId());
        }

        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
        if (dto == null) return null;

        Category category = new Category();
        category.setName(dto.getName());
       

        return category;
    }
}