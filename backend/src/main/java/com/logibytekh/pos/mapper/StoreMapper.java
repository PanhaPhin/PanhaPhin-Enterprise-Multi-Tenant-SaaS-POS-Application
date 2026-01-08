package com.logibytekh.pos.mapper;

import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.StoreDTO;

public class StoreMapper {

    public static StoreDTO tDto(Store store) {
    if (store == null) return null;

    StoreDTO dto = new StoreDTO();
    dto.setId(store.getId());
    dto.setBrand(store.getBrand());
    dto.setDescription(store.getDescription());

    // FIX: Prevent null pointer when no store admin assigned
    if (store.getStoreAdmin() != null) {
        dto.setStoreAdmin(UserMapper.toDto(store.getStoreAdmin()));
    } else {
        dto.setStoreAdmin(null); // or skip setting it
    }

    dto.setStoreType(store.getStoreType());
    dto.setContact(store.getContact());
    dto.setCreatedAt(store.getCreatedAt());
    dto.setUpDatedAt(store.getUpdatedAt());
    dto.setStatus(store.getStatus());
    return dto;
}


    public static Store toEntity(StoreDTO dto, User storeAdmin) {
        Store store = new Store();
        store.setBrand(dto.getBrand());
        store.setDescription(dto.getDescription());
        store.setStoreAdmin(storeAdmin);
        store.setStoreType(dto.getStoreType());
        store.setContact(dto.getContact());
        return store;
    }


    
}
