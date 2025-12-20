package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.payload.dto.ProductDTO;
import com.logibytekh.pos.modal.Category;


public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        if(product == null){
            return null;
        }
      return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .mrp(product.getMrp())
                .sellingPrice(product.getSellingPrice())
                .brand(product.getBrand())
                .image(product.getImage())
                .storeId(product.getStore() != null ? product.getStore().getId() : null)
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
               

    }

    public static Product toEntity(ProductDTO productDTO ,Store store,Category category) {
        if(productDTO == null){
            return null;
        }
        return Product.builder()
              .name(productDTO.getName())
                .sku(productDTO.getSku())
                .description(productDTO.getDescription())
                .mrp(productDTO.getMrp())
                .sellingPrice(productDTO.getSellingPrice())
                .brand(productDTO.getBrand())
                .image(productDTO.getImage())
                .store(store)
                .category(category)
                .build();
               
        
    }
    
}
