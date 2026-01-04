package com.logibytekh.pos.payload.dto;

import java.util.List;

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
    private Long customerId;
    private PaymentType paymentType;
    private List<OrderItemRequestDTO> items;
}
