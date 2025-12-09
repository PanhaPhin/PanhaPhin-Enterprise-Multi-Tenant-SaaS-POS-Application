package com.logibytekh.pos.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.mapper.ProductMapper;
import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.ProductDTO;
import com.logibytekh.pos.repository.ProductRespository;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.service.ProductService;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public  class ProductServiceImpl implements ProductService{

    private final  ProductRespository productRespository;
    private final  StoreRepository storeRepository;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {
       Store store = storeRepository.findById(
        productDTO.getStoreId()
       ).orElseThrow(
        () -> new Exception("Store not found")
       );

       Product product= ProductMapper.toEntity(productDTO, store);
       Product saveProduct=productRespository.save(product);


       return ProductMapper.toDto(saveProduct);
    }
    

   @Override
public ProductDTO upadateProduct(Long id, ProductDTO productDTO, User user) {

    Product product = productRespository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found")
        
        );

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(product.getImage());
        product.setSellingPrice(product.getSellingPrice());
        product.setBrand(product.getBrand());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct=productRespository.save(product);
        return ProductMapper.toDto(saveProduct);

}


    @Override
    public void deleteProduct(Long id, User user) throws Exception{

        Product product = productRespository.findById(id).orElseThrow(
            ()-> new Exception("product not found")
        );
        productRespository.delete(product);
      
    }

    @Override
    public List<ProductDTO> getProducts(User user) {
       return null;
    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {
       return null;
    }

   
    
}
