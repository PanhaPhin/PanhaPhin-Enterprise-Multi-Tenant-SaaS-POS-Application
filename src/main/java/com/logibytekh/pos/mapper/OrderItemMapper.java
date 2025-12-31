package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.OrderItem;
import com.logibytekh.pos.payload.dto.OrderitemDTO;

public class OrderItemMapper {

    public static OrderitemDTO toDTO(OrderItem item) {

        if (item == null) return null;

        return OrderitemDTO.builder()
                .id(item.getId())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .productId(ProductMapper.toDto(item.getProduct())) 
                .orderId(item.getOrder() != null ? item.getOrder().getId() : null)
                .build(); 
    }
}
