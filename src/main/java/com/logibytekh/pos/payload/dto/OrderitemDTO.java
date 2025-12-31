package com.logibytekh.pos.payload.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class OrderitemDTO {

    private Long id;

    private Integer quantity;

    private Double price;

    
    private ProductDTO productId;

    private Long orderId;


}
