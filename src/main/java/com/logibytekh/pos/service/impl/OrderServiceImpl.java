package com.logibytekh.pos.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.domain.OrderStatus;
import com.logibytekh.pos.domain.PaymentType;
import com.logibytekh.pos.mapper.OrderMapper;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.modal.OrderItem;
import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.OrderDTO;
import com.logibytekh.pos.repository.ProductRespository;
import com.logibytekh.pos.service.OrderService;
import com.logibytekh.pos.service.UserService;
import com.logibytekh.pos.repository.OrderRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final ProductRespository productRespository;
    private final OrderRespository orderRespository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        User cashier = userService.getCurrentUser();

        Branch branch = cashier.getBranch();
        if (branch == null) {
            throw new Exception("Cashier is not assigned to any branch");
        }

        Order order = Order.builder()
                .branch(branch)
                .cashier(cashier)
                .customer(orderDTO.getCustomer())
                .paymentType(orderDTO.getPaymentType())
                .build();

        List<OrderItem> orderItems = (List<OrderItem>) orderDTO.getItems().stream().map(itemDTO -> {
            Product product = productRespository.findById(itemDTO.getProductId().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found "));

            return OrderItem.builder()
                    .product(product)
                    .quantity(itemDTO.getQuantity())
                    .price(product.getSellingPrice() * itemDTO.getQuantity())
                    .order(order)
                    .build();
        }).toList();
        double total = orderItems.stream().mapToDouble(
                OrderItem::getPrice).sum();
        order.setTotalAmount(total);
        order.setItems(orderItems);

        Order savedOrder = orderRespository.save(order);

        return OrderMapper.toDTO(savedOrder);

    }

    @Override
    public OrderDTO getOrderById(Long id) throws Exception {
        return orderRespository.findById(id)
                .map(OrderMapper::toDTO)
                .orElseThrow(() -> new Exception("Order not found  "));
    }

    @Override
    public List<OrderDTO> getOrdersByBranch(Long branchId, Long customerId, Long cashierId,
            PaymentType paymentType, OrderStatus status) throws Exception {

        return orderRespository.findByBranchId(branchId).stream()
                .filter(order -> customerId == null
                        || (order.getCustomer() != null && order.getCustomer().getId().equals(customerId)))
                .filter(order -> cashierId == null
                        || (order.getCashier() != null && order.getCashier().getId().equals(cashierId)))
                .filter(order -> paymentType == null
                        || order.getPaymentType() == paymentType)
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList()); // <- semicolon added
    }

    @Override
    public List<OrderDTO> getOrderByCashierId(Long cashierId) {
        return orderRespository.findByCashierId(cashierId).stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) throws Exception {
        Order order = orderRespository.findById(id)
                .orElseThrow(() -> new Exception("Order not found "));

        orderRespository.delete(order);
    }

    @Override
    public List<OrderDTO> getTodayOrdersByBranch(Long branchId) throws Exception {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        return orderRespository.findByBranchIdAndCreatedAtBetween(branchId, start, end)
                .stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception {
        return orderRespository.findByCustomerId(customerId).stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDTO> getTop5RecentOrdersByBranch(Long branchId) throws Exception {
        return orderRespository.findTop5ByOrderByCreatedAtDesc(branchId).stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

}
