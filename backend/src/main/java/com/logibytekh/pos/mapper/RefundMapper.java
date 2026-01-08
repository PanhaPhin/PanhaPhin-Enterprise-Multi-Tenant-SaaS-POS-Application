package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Refund;
import com.logibytekh.pos.payload.dto.RefundDTO;

public class RefundMapper {

    public static RefundDTO toDTO(Refund refund) {
        if (refund == null) {
            return null;
        }

        return RefundDTO.builder()
                .id(refund.getId())
                .orderId(refund.getOrder() != null ? refund.getOrder().getId() : null)
                .order(OrderMapper.toDTO(refund.getOrder()))
                .reason(refund.getReason())
                .amount(refund.getAmount())
                .cashierId(refund.getCashier() != null ? refund.getCashier().getId() : null)
                .cashierName(refund.getCashier() != null ? refund.getCashier().getFullName() : null)
                .branchId(refund.getBranch() != null ? refund.getBranch().getId() : null)
                .branch(refund.getBranch() != null ? BranchMapper.tDto(refund.getBranch()) : null)
                .shiftReportId(refund.getShiftReport() != null ? refund.getShiftReport().getId() : null)
                .paymentType(refund.getPaymentType())
                .createdAt(refund.getCreatedAt())
                .build();
    }
}
