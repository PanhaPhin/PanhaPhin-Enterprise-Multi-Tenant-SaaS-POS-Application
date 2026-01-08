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
import com.logibytekh.pos.modal.Customer;
import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.modal.OrderItem;
import com.logibytekh.pos.modal.Product;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.OrderDTO;
import com.logibytekh.pos.payload.dto.OrderRequestDTO;
import com.logibytekh.pos.repository.ProductRepository;
import com.logibytekh.pos.service.OrderService;
import com.logibytekh.pos.service.UserService;


import com.logibytekh.pos.repository.CustomerRepository;
import com.logibytekh.pos.repository.OrderItemRepository;
import com.logibytekh.pos.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

        private final UserService userService;
        private final ProductRepository productRepository;
        private final OrderRepository orderRepository;

        private final OrderItemRepository orderItemRepository;
        private final CustomerRepository customerRepository;

        @Override
        public OrderDTO createOrder(OrderRequestDTO orderRequest) throws Exception {

                User cashier = userService.getCurrentUser();
                Branch branch = cashier.getBranch();

                Customer customer = null;
                if (orderRequest.getCustomerId() != null) {
                        customer = customerRepository.findById(orderRequest.getCustomerId())
                                        .orElseThrow(() -> new RuntimeException("Customer not found"));
                }

                Order order = Order.builder()
                                .branch(branch)
                                .cashier(cashier)
                                .customer(customer)
                                .paymentType(orderRequest.getPaymentType())
                                .build();

                Order savedOrder = orderRepository.save(order);

                List<OrderItem> items = orderRequest.getItems().stream().map(dto -> {

                        if (dto.getProductId() == null) {
                                throw new RuntimeException("Product ID must not be null");
                        }

                        Product product = productRepository.findById(dto.getProductId())
                                        .orElseThrow(() -> new RuntimeException("Product not found"));

                        return OrderItem.builder()
                                        .order(savedOrder)
                                        .product(product)
                                        .quantity(dto.getQuantity())
                                        .price(product.getSellingPrice() * dto.getQuantity())
                                        .build();
                }).toList();

                orderItemRepository.saveAll(items);

                double total = items.stream().mapToDouble(OrderItem::getPrice).sum();
                savedOrder.setTotalAmount(total);
                savedOrder.setItems(items);

                return OrderMapper.toDTO(savedOrder);
        }

        @Override
        public OrderDTO getOrderById(Long id) throws Exception {
                return orderRepository.findById(id)
                                .map(OrderMapper::toDTO)
                                .orElseThrow(() -> new Exception("Order not found  "));
        }

        @Override
        public List<OrderDTO> getOrdersByBranch(Long branchId, Long customerId, Long cashierId,
                        PaymentType paymentType, OrderStatus status) throws Exception {

                return orderRepository.findByBranchId(branchId).stream()
                                .filter(order -> customerId == null
                                                || (order.getCustomer() != null
                                                                && order.getCustomer().getId().equals(customerId)))
                                .filter(order -> cashierId == null
                                                || (order.getCashier() != null
                                                                && order.getCashier().getId().equals(cashierId)))
                                .filter(order -> paymentType == null
                                                || order.getPaymentType() == paymentType)
                                .map(OrderMapper::toDTO)
                                .collect(Collectors.toList()); // <- semicolon added
        }

        @Override
        public List<OrderDTO> getOrderByCashierId(Long cashierId) {
                return orderRepository.findByCashierId(cashierId).stream()
                                .map(OrderMapper::toDTO)
                                .collect(Collectors.toList());
        }

        @Override
        public void deleteOrder(Long id) throws Exception {
                Order order = orderRepository.findById(id)
                                .orElseThrow(() -> new Exception("Order not found "));

                orderRepository.delete(order);
        }

        @Override
        public List<OrderDTO> getTodayOrdersByBranch(Long branchId) throws Exception {
                LocalDate today = LocalDate.now();
                LocalDateTime start = today.atStartOfDay();
                LocalDateTime end = today.plusDays(1).atStartOfDay();

                return orderRepository.findByBranchIdAndCreatedAtBetween(branchId, start, end)
                                .stream()
                                .map(OrderMapper::toDTO)
                                .collect(Collectors.toList());

        }

        @Override
        public List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception {
                return orderRepository.findByCustomerId(customerId).stream()
                                .map(OrderMapper::toDTO)
                                .collect(Collectors.toList());

        }

        @Override
        public List<OrderDTO> getTop5RecentOrdersByBranch(Long branchId) throws Exception {
                return orderRepository.findTop5ByOrderByCreatedAtDesc(branchId).stream()
                                .map(OrderMapper::toDTO)
                                .collect(Collectors.toList());
        }

}
