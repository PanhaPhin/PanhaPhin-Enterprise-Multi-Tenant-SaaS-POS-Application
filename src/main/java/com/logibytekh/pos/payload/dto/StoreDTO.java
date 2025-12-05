package com.logibytekh.pos.payload.dto;

import java.time.LocalDateTime;

import com.logibytekh.pos.domain.StoreStatus;
import com.logibytekh.pos.modal.StoreContact;

import lombok.Data;

@Data
public class StoreDTO {

    
    private Long id;


    
    private String brand;

    
    private UserDto storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime upDatedAt;


    private String description;

    private String storeType;

    private StoreStatus status;

    private StoreContact contact ;
    
}
