package com.logibytekh.pos.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(
        @RequestBody CategoryDTO categoryDTO)throws Exception{
            return ResponseEntity.ok(
                categoryService.createCategory(categoryDTO)
            );


        }

         @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByStoreId(
        @PathVariable Long storeId)throws Exception{
            return ResponseEntity.ok(
                categoryService.getCategoriesByStoreId(storeId)
            );


        }
@GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
        @RequestBody CategoryDTO categoryDTO,
        @PathVariable Long id)throws Exception{
            return ResponseEntity.ok(
                categoryService.updateCategory(id, categoryDTO)
            );


        }

        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse> deleteCategory(
        @RequestBody CategoryDTO categoryDTO,
        @PathVariable Long id)throws Exception{


            categoryService.updateCategory(id,categoryDTO);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("category deleted successfully");
            return ResponseEntity.ok(
                apiResponse
            );


        }

        


    
    
}
