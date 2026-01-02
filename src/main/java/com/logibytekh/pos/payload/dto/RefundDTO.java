package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.logibytekh.pos.domain.PaymentType;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RefundDTO {


    private Long id;

    private OrderDTO order;
    private Long orderId;

    private String reason;

    private Double amount;

    
    // private ShiftReport shiftReport;

    private Long shiftReportId;

 
    private UserDto cashier;
    private String cashierName;


    private BranchDTO branch;
    private Long branchId;

    
   

    private PaymentType paymentType;

    
    private LocalDateTime createdAt;
    
}
