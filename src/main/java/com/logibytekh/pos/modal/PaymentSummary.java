package com.logibytekh.pos.modal;

import com.logibytekh.pos.domain.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSummary {

    private PaymentType type;
    private Double totalAmount;
    private int transactionCount;
    private double percentage;
}
