package com.logibytekh.pos.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logibytekh.pos.domain.PaymentType;

public class OrderReqDto {

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("paymentType")
    private PaymentType paymentType;

    // getters & setters
}

