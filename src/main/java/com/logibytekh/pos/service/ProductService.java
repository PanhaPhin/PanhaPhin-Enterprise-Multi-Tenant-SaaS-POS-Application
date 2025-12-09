package com.logibytekh.pos.service;

import java.util.List;

import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.ProductDTO;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception;
    ProductDTO upadateProduct(Long id,ProductDTO productDTO, User user);

    void deleteProduct(Long id , User user) throws Exception;
    List<ProductDTO> getProducts(User user);
    List<ProductDTO> searchByKeyword(Long storeId, String keyword);




    
}
