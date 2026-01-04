package com.logibytekh.pos.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequestDTO {
    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("quantity")
    private Integer quantity;
}
