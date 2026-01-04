package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.OrderItem;
import com.logibytekh.pos.payload.dto.OrderItemDTO;


public class OrderItemMapper {

    public static OrderItemDTO   toDTO(OrderItem item) {

        if (item == null)
            return null;

        return OrderItemDTO  .builder()
                .id(item.getId())
                .productId(item.getProduct().getId())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .orderId(item.getOrder().getId())
                .build();
    }
}
