package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.logibytekh.pos.domain.PaymentType;
import com.logibytekh.pos.modal.Customer;
import com.logibytekh.pos.modal.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
    private Long id;

    private Double totalAmount;

    private LocalDateTime createdAt;

    private Long branchId;
    private Long customerId;

    private BranchDTO branch;

    private User cashier;

    private Customer customer;
    
    private PaymentType paymentType;


    private List<OrderitemDTO> items;

    

}
