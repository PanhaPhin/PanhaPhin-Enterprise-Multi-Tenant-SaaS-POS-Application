package com.logibytekh.pos.payload.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logibytekh.pos.domain.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    @JsonProperty("customerId")
    private Long customerId;
    @JsonProperty("paymentType")
    private PaymentType paymentType;
    @JsonProperty("items")
    private List<OrderItemRequestDTO> items;
}
