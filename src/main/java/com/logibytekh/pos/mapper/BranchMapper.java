package com.logibytekh.pos.mapper;

import java.time.LocalDateTime;

import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.payload.dto.BranchDTO;


public class BranchMapper {
    public static BranchDTO tDto(Branch branch){
        return BranchDTO.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .phone(branch.getPhone())
                .email(branch.getEmail())
                .closeTime(branch.getCloseTime())
                .openTime(branch.getOpenTime())
                .workingDays(branch.getWorkingDays())
                .StoreId(branch.getStore()!=null?branch.getStore().getId():null)
                .createdAt(branch.getCreatedAt())
                .updatedAt(branch.getUpdatedAt())
                .build();
                

    }

    public static Branch toEntity(BranchDTO branchDTO, Store store){
        return Branch.builder()
        .name(branchDTO.getName())
        .address(branchDTO.getAddress())
        .store(store)
        .email(branchDTO.getEmail())
        .phone(branchDTO.getPhone())
        .closeTime(branchDTO.getCloseTime())
        .openTime(branchDTO.getOpenTime())
        .workingDays(branchDTO.getWorkingDays())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
    }

  
    
}
