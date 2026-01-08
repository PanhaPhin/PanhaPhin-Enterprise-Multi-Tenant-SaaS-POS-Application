package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;
import java.util.List;


import com.logibytekh.pos.modal.PaymentSummary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShiftReportDTO {

    
    private Long id;

    private LocalDateTime shiftStart;

    private LocalDateTime shiftEnd;

    private Double totalSales;

    private Double totalRefunds;

    private Double netSales;

    private Double totalOrders;

 
    private UserDto cashier;
    private Long cashierId;
    private Long branchId;
    
    private BranchDTO branch;

    
    private List<PaymentSummary> paymentSummaries;


    private List<ProductDTO> topSellingProducts;

    
    private List<OrderDTO> recentOrders;

    
    private List<RefundDTO> refunds;

}
