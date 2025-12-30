package com.logibytekh.pos.payload.dto;



import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderitemDTO {

    private Long id;

    private Integer quantity;

    private Double price;

    @ManyToOne
    private ProductDTO product;

    private Long orderId;
}
