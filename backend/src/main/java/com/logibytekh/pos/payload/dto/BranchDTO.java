package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

    
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    
    private List<String> workingDays;

    private LocalTime openTime;

    private LocalTime closeTime;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
    private StoreDTO store;

    private UserDto manager;

    private Long storeId;

    
}
