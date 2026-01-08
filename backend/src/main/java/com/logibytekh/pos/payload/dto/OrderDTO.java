package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;
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
public class OrderDTO {
    private Long id;
    private Double totalAmount;
    private LocalDateTime createdAt;

    private Long branchId;
    private Long cashierId;
    private Long customerId;

    private PaymentType paymentType;

    private List<OrderItemDTO> items;

    

}
