package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logibytekh.pos.domain.PaymentType;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefundDTO {

    private Long id;

    @NotNull(message = "Order ID must not be null")
    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OrderDTO order;

    private String reason;

    @NotNull(message = "Amount must not be null")
    private Double amount;

    private Long shiftReportId;

    private Long cashierId;
    private UserDto cashier;
    private String cashierName;

    private Long branchId;
    private BranchDTO branch;

    private PaymentType paymentType;

    private LocalDateTime createdAt;
}
