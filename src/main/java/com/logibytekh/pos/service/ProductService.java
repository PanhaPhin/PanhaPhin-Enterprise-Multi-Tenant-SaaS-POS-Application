package com.logibytekh.pos.service;

import java.util.List;

import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.ProductDTO;
import com.logibytekh.pos.payload.response.ApiResponse;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception;
    ProductDTO updateProduct(Long id,ProductDTO productDTO, User user) ;

    ApiResponse deleteProduct(Long id , User user) throws Exception;
    List<ProductDTO> getProducts(User user);
    List<ProductDTO> searchByKeyword(Long storeId, String keyword);
    List<ProductDTO> getProductsByStoreId(Long storeId);
    



    
}
