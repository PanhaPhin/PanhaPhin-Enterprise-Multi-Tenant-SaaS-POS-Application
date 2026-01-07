package com.logibytekh.pos.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO   {

    private Long id;

    private Integer quantity;

    private Double price;

    
    private Long productId;

    private Long orderId;


}


