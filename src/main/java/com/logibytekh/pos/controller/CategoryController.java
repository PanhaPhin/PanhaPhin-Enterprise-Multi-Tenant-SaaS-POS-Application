package com.logibytekh.pos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.CategoryDTO;
import com.logibytekh.pos.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(
        @RequestBody CategoryDTO categoryDTO) throws Exception{
            return ResponseEntity.ok(
                categoryService.createCategory(categoryDTO)

            );
        }
    
    
}
