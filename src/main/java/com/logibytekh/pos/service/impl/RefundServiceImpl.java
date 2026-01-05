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
import com.logibytekh.pos.repository.OrderRepository;
import com.logibytekh.pos.repository.RefundRepository;
import com.logibytekh.pos.service.RefundService;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final UserService userService;
    private final OrderRepository orderRespository;
    private final RefundRepository refundRepository;

    @Override
    public RefundDTO createRefund(RefundDTO refund) throws Exception {
        User cashier = userService.getCurrentUser();

        Order order = orderRespository.findById(refund.getOrderId()).orElseThrow(
                () -> new Exception("Order not found"));
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
    public List<RefundDTO> getRefundByCashier(Long cashierId) throws Exception {
        return refundRepository.findByCashierId(cashierId).stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RefundDTO> getRefundByShiftReport(Long shiftReportId) throws Exception {
        return refundRepository.findByShiftReportId(shiftReportId).stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RefundDTO> getRefundByCashierAndDateRange(Long cashierId, LocalDateTime startDate,
            LocalDateTime endDate) throws Exception {
        return refundRepository.findByCashierIdAndCreatedAtBetween(cashierId, startDate, endDate).stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<RefundDTO> getRefundByBranch(Long branchId) throws Exception {
        return refundRepository.findByBranchId(branchId).stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RefundDTO getRefundById(Long refundId) throws Exception {

        return refundRepository.findById(refundId)
                .map(RefundMapper::toDTO).orElseThrow(() -> new Exception("Refund not found"));
    }

    @Override
    public void deleteRefund(Long refundId) throws Exception {
        this.getRefundById(refundId);
        refundRepository.deleteById(refundId);
    }

}
