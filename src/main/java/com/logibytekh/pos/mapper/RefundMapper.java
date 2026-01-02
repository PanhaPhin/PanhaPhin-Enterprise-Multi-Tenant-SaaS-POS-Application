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
                .order(OrderMapper.toDTO(refund.getOrder()))
                .reason(refund.getReason())
                .amount(refund.getAmount())
                .cashierName(refund.getCashier().getFullName())
                .branchId(refund.getBranch().getId())
                .shiftReportId(refund.getShiftReport().getId())
                .createdAt(refund.getCreatedAt())
                .build();

                
    }
    
}
