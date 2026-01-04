package com.logibytekh.pos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.domain.OrderStatus;
import com.logibytekh.pos.domain.PaymentType;
import com.logibytekh.pos.payload.dto.OrderDTO;
import com.logibytekh.pos.payload.dto.OrderReqDto;
import com.logibytekh.pos.payload.dto.OrderRequestDTO;
import com.logibytekh.pos.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequest) throws Exception {
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }


    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody OrderReqDto orderReqDto){
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(
            @PathVariable Long id) throws Exception {

        return ResponseEntity.ok(orderService.getOrderById(id));

    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByBranch(
            @PathVariable Long branchId,
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) Long cashierId,
            @RequestParam(required = false) PaymentType paymentType,
            @RequestParam(required = false) OrderStatus orderStatus

    ) throws Exception {

        return ResponseEntity
                .ok(orderService.getOrdersByBranch(branchId, customerId, cashierId, paymentType, orderStatus));
    }

    @GetMapping("/cashier/{id}")
    public ResponseEntity<List<OrderDTO>> getOrderByCashier(
            @PathVariable Long id) throws Exception {

        return ResponseEntity.ok(orderService.getOrderByCashierId(id));

    }

    @GetMapping("/today/branch/{id}")
    public ResponseEntity<List<OrderDTO>> getTodayOrder(
            @PathVariable Long id) throws Exception {

        return ResponseEntity.ok(orderService.getTodayOrdersByBranch(id));

    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderDTO>> getCustomersOder(
            @PathVariable Long id) throws Exception {

        return ResponseEntity.ok(orderService.getOrdersByCustomerId(id));

    }

    @GetMapping("/recent/{branchId}")
    public ResponseEntity<List<OrderDTO>> getRecentOrder(
            @PathVariable Long branchId) throws Exception {

        return ResponseEntity.ok(orderService.getTop5RecentOrdersByBranch(branchId));

    }

}
