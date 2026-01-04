package com.logibytekh.pos.mapper;

import java.util.stream.Collectors;

import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.payload.dto.OrderDTO;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {

        return OrderDTO.builder()
                .id(order.getId())
                .totalAmount(order.getTotalAmount())
                .createdAt(order.getCreatedAt())
                .branchId(order.getBranch().getId())
                .cashierId(order.getCashier().getId())
                .customerId(
                        order.getCustomer() != null
                                ? order.getCustomer().getId()
                                : null)
                .paymentType(order.getPaymentType())
                .items(order.getItems() != null
                        ? order.getItems().stream()
                                .map(OrderItemMapper::toDTO)
                                .collect(Collectors.toList())
                        : null)
                .build();
    }
}
