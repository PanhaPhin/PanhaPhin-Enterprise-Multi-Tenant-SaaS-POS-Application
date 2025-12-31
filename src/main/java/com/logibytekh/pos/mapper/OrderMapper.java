package com.logibytekh.pos.mapper;

import java.util.stream.Collectors;

import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.payload.dto.OrderDTO;



public class OrderMapper {

    public static OrderDTO toDTO(Order order){

        return OrderDTO.builder()
                .id(order.getId())
                .totalAmount(order.getTotalAmount())
                .branchId(order.getBranch().getId())
                .cashier(order.getCashier())
                .customer(order.getCustomer())
                .paymentType(order.getPaymentType())
                .createdAt(order.getCreatedAt())
                .items(order.getItems().stream()
                     .map(OrderItemMapper::toDTO)
                     .collect(Collectors.toList()))



                .build();
                
                

        
    }
    
}
