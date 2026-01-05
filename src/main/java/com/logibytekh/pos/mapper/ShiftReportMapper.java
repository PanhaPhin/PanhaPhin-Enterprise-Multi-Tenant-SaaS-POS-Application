package com.logibytekh.pos.mapper;

import com.logibytekh.pos.payload.dto.OrderDTO;
import com.logibytekh.pos.payload.dto.ProductDTO;
import com.logibytekh.pos.payload.dto.RefundDTO;
import com.logibytekh.pos.payload.dto.ShiftReportDTO;

import java.util.List;
import java.util.stream.Collectors;

import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.modal.Refund;
import com.logibytekh.pos.modal.ShiftReport;


public class ShiftReportMapper {

    public static ShiftReportDTO toDTO(ShiftReport entity) {
    
        return ShiftReportDTO.builder()
                .id(entity.getId())
                .shiftStart(entity.getShiftStart())
                .shiftEnd(entity.getShiftEnd())
                .totalSales(entity.getTotalSales())
                .totalRefunds(entity.getTotalRefunds())
                .netSales(entity.getNetSales())
                .totalOrders(entity.getTotalOrders())
                .cashierId(entity.getCashier().getId())
                .branchId(entity.getBranch().getId())
                .recentOrders(mapOrders(entity.getRecentOrders()))
                .topSellingProducts(mapProducts(entity.getTopSellingProducts()))
                .refunds(mapRefunds(entity.getRefunds()))
                .paymentSummaries(entity.getPaymentSummaries())
                .build();
                
    }

    private static List<RefundDTO> mapRefunds(List<Refund> refunds) {
       if (refunds == null || refunds.isEmpty()) {return null;}


       return refunds.stream().map(RefundMapper::toDTO).collect(Collectors.toList());

       
    }

    private static List<ProductDTO> mapProducts(List<Product> topSellingProducts) {
        if (topSellingProducts == null || topSellingProducts.isEmpty()) {
            return null;
        }
        return topSellingProducts.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }
    private static List<OrderDTO> mapOrders(List<Order> recentOrders) {
         if (recentOrders == null || recentOrders.isEmpty()) {
            return null;
        }
        return recentOrders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    
}
