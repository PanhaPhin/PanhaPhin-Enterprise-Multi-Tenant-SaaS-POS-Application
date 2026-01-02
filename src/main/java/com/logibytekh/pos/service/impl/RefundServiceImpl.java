package com.logibytekh.pos.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.mapper.RefundMapper;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Order;
import com.logibytekh.pos.modal.Refund;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.RefundDTO;
import com.logibytekh.pos.repository.OrderRespository;
import com.logibytekh.pos.repository.RefundReespository;
import com.logibytekh.pos.service.RefundService;
import com.logibytekh.pos.service.UserService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final UserService userService;
    private final OrderRespository orderRespository;
    private final RefundReespository refundRepository;




    @Override
    public RefundDTO createRefund(RefundDTO refund) throws Exception {
       User cashier = userService.getCurrentUser();

       Order order = orderRespository.findById(refund.getOrderId()).orElseThrow(
        () -> new Exception("Order not found")
       );
       Branch branch = order.getBranch();

       Refund createdRefund = Refund.builder()
        .order(order)
        .branch(branch)
        .cashier(cashier)
        .amount(refund.getAmount())
        .reason(refund.getReason())
        .createdAt(refund.getCreatedAt())
        .build();

        Refund savedRefund = refundRepository.save(createdRefund);
        return RefundMapper.toDTO(savedRefund); 

    }

    @Override
    public List<RefundDTO> getAllRefunds() throws Exception {
       return refundRepository.findAll().stream()
        .map(RefundMapper::toDTO)
        .collect(Collectors.toList());
    }

    @Override
    public RefundDTO getRefundByCashier(Long cashierId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRefundByCashier'");
    }

    @Override
    public RefundDTO getRefundByShiftReport(Long shiftReportId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRefundByShiftReport'");
    }

    @Override
    public List<RefundDTO> getRefundByCashierAndDateRange(Long cashierId, LocalDateTime startDate,
            LocalDateTime endDate) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRefundByCashierAndDateRange'");
    }

    @Override
    public List<RefundDTO> getRefundByBranch(Long branchId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRefundByBranch'");
    }

    @Override
    public RefundDTO getRefundById(Long refundId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRefundById'");
    }

    @Override
    public void deleteRefund(Long refundId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRefund'");
    }
    
}
