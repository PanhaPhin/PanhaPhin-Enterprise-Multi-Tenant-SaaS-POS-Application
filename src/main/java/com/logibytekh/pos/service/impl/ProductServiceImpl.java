package com.logibytekh.pos.service.impl;

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
      return null;
    }

    @Override
    public void deleteProduct(Long id, User user) {
      
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
