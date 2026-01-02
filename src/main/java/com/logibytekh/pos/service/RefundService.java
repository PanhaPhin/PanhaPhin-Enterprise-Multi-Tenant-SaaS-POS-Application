package com.logibytekh.pos.service;

import java.time.LocalDateTime;
import java.util.List;

import com.logibytekh.pos.payload.dto.RefundDTO;

import com.logibytekh.pos.modal.Refund;

public interface  RefundService {

    RefundDTO createRefund(RefundDTO refund) throws Exception;
    List<RefundDTO> getAllRefunds() throws Exception;
    RefundDTO getRefundByCashier(Long cashierId) throws Exception;
    RefundDTO getRefundByShiftReport(Long shiftReportId) throws Exception;
    List<RefundDTO> getRefundByCashierAndDateRange(Long cashierId, LocalDateTime startDate,LocalDateTime endDate) throws Exception;
    List<RefundDTO> getRefundByBranch(Long branchId) throws Exception;


    RefundDTO getRefundById(Long refundId) throws Exception;
    void deleteRefund(Long refundId) throws Exception;

    
}
