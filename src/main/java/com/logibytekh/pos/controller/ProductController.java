package com.logibytekh.pos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.ProductDTO;
import com.logibytekh.pos.payload.response.ApiResponse;
import com.logibytekh.pos.service.ProductService;
import com.logibytekh.pos.service.UserService;
import com.logibytekh.pos.modal.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;
    

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(
                productService.createProduct(
                        productDTO, null

            )
        );

    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<ProductDTO>> getByStoreId(
            @PathVariable Long storeId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(
                productService.getProductsByStoreId(storeId)
        );
    }

    @PatchMapping("/{id}")
public ResponseEntity<ProductDTO> update(
        @PathVariable Long id,
        @RequestBody ProductDTO productDTO,
        @RequestHeader("Authorization") String jwt) throws Exception {
            
    User user = userService.getUserFromJwtToken(jwt);

    return ResponseEntity.ok(
            productService.updateProduct(id, productDTO, user
            )
    );
}


@GetMapping("/store/{storeId}/search")
    public ResponseEntity<List<ProductDTO>> searchByKeyword(
            @PathVariable Long storeId,
            @RequestBody String keyword,
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(
                productService.getProductsByStoreId(
                    storeId
            )
        );
    }







@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse> delete(
        @PathVariable Long id,
        @RequestHeader("Authorization") String jwt) throws Exception {

    User user = userService.getUserFromJwtToken(jwt);
    productService.deleteProduct(id, user);
    ApiResponse response = new ApiResponse();

    return ResponseEntity.ok(response);
}

}
