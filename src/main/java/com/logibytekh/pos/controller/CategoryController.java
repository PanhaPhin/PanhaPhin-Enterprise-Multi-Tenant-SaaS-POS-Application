package com.logibytekh.pos.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import com.logibytekh.pos.service.CategoryService;
import com.logibytekh.pos.payload.dto.CategoryDTO;
import com.logibytekh.pos.payload.response.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // CREATE CATEGORY
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(
            @RequestBody CategoryDTO categoryDTO) throws Exception {
        return ResponseEntity.ok(
                categoryService.createCategory(categoryDTO)
        );
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByStoreId(
            @PathVariable Long storeId) {
        return ResponseEntity.ok(
                categoryService.getCategoriesByStoreId(storeId)
        );
    }


    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    
    

    // UPDATE CATEGORY
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO) throws Exception {
        return ResponseEntity.ok(
                categoryService.updateCategory(id, categoryDTO)
        );
    }

    // DELETE CATEGORY
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(
            @PathVariable Long id) throws Exception {
                categoryService.deleteCategory(id);
                


        categoryService.deleteCategory(id);

        ApiResponse response = new ApiResponse();
        response.setMessage("Category deleted successfully");

        return ResponseEntity.ok(response);
    }

}
