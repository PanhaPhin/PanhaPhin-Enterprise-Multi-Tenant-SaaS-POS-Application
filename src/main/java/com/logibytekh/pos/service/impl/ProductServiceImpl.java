package com.logibytekh.pos.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.logibytekh.pos.modal.Category;

import com.logibytekh.pos.mapper.ProductMapper;
import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.ProductDTO;
import com.logibytekh.pos.payload.response.ApiResponse;
import com.logibytekh.pos.repository.CategoryRespository;
import com.logibytekh.pos.repository.ProductRespository;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import com.logibytekh.pos.modal.Category;
import com.logibytekh.pos.repository.CategoryRespository;








@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRespository productRespository;
    private final StoreRepository storeRepository;
    private final CategoryRespository categoryRespository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {
        Store store = storeRepository.findById(
                productDTO.getStoreId()).orElseThrow(
                        () -> new Exception("Store not found")
        );


        Category category = categoryRespository.findById(
                productDTO.getCategoryId()).orElseThrow(
                        () -> new Exception("Category not found"));

        Product product = ProductMapper.toEntity(productDTO, store, category);
        Product saveProduct = productRespository.save(product);
        return ProductMapper.toDto(saveProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) {

        Product product = productRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")
        );


        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(productDTO.getImage());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setMrp(productDTO.getMrp());
        product.setBrand(productDTO.getBrand());
        product.setUpdatedAt(LocalDateTime.now());

         if(productDTO.getCategoryId()!=null){
                Category category = categoryRespository.findById(productDTO.getCategoryId()).orElseThrow(
            () -> new RuntimeException("Category not found")
        );
        product.setCategory(category);

        }

        Product savedProduct = productRespository.save(product);
        return ProductMapper.toDto(savedProduct);
    }

   @Override
    public void deleteProduct(Long id, User user) throws Exception {
    Product product = productRespository.findById(id)
            .orElseThrow(() -> new Exception("Product not found"));
    
            productRespository.delete(product);
}


    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {

        List<Product> products =
                productRespository.searchByKeyword(storeId, keyword);

        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

     @Override
    public List<ProductDTO> getProductsByStoreId(Long storeId) {

        List<Product> products = productRespository.findByStoreId(storeId);

        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProducts(User user) {

        Store store = storeRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("Store not found for user"));

        List<Product> products = productRespository.findByStoreId(store.getId());

        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

}
