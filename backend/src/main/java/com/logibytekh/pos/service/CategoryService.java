package com.logibytekh.pos.service;


import com.logibytekh.pos.payload.dto.CategoryDTO;

import java.util.List;

public interface  CategoryService {

    CategoryDTO createCategory(CategoryDTO dto) throws Exception ;
    List<CategoryDTO> getCategoriesByStoreId(Long storeId);
    CategoryDTO updateCategory(Long id, CategoryDTO dto) throws Exception ; 
    void deleteCategory(Long id) throws Exception;

    CategoryDTO getCategoryById(Long id) throws Exception ;

    
}
