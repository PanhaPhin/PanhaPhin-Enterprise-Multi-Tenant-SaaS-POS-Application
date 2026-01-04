package com.logibytekh.pos.service;

import java.util.List;

import com.logibytekh.pos.domain.OrderStatus;
import com.logibytekh.pos.domain.PaymentType;
import com.logibytekh.pos.payload.dto.OrderDTO;
import com.logibytekh.pos.payload.dto.OrderRequestDTO;

public interface  OrderService {

    OrderDTO createOrder(OrderRequestDTO orderRequest) throws Exception;
    OrderDTO getOrderById(Long id) throws Exception;
    List<OrderDTO> getOrdersByBranch(Long branchId , Long customerId, Long cashierId, PaymentType paymentType, OrderStatus status) throws Exception;

    List<OrderDTO> getOrderByCashierId(Long cashierId) ;
    void deleteOrder(Long id) throws Exception;
    List<OrderDTO> getTodayOrdersByBranch(Long branchId) throws Exception;
    List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception;
    List<OrderDTO>getTop5RecentOrdersByBranch(Long branchId) throws Exception;

    
    
}
