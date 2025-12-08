package com.logibytekh.pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.domain.StoreStatus;
import com.logibytekh.pos.mapper.StoreMapper;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.StoreContact;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.StoreDTO;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.service.StoreService;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
public StoreDTO createStore(StoreDTO storeDTO, User user) {
    if (user == null) {
        throw new RuntimeException("Store admin cannot be null");
    }

    Store store = StoreMapper.toEntity(storeDTO, user);
    return StoreMapper.tDto(storeRepository.save(store));
}


    @Override
    public StoreDTO getStoreById(Long id) throws Exception {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new Exception("Store not found"));
        return StoreMapper.tDto(store);
    }

    @Override
    public List<StoreDTO> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return stores.stream().map(StoreMapper::tDto).collect(Collectors.toList());
    }

    @Override
    public Store getStoreByAdmin() throws Exception {
        User admin = userService.getCurrentUser();
        Store store = storeRepository.findByStoreAdminId(admin.getId());

        if (store == null) {
            throw new Exception("Store not found for this admin");
        }

        return store;
    }

    @Override
    public StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception {
        User currentUser = userService.getCurrentUser();

        Store existing = storeRepository.findById(id)
                .orElseThrow(() -> new Exception("Store not found"));

        // SAFETY FIX: Prevent NullPointerException
        if (existing.getStoreAdmin() == null) {
            throw new Exception("This store has no admin assigned");
        }

        if (!existing.getStoreAdmin().getId().equals(currentUser.getId())) {
            throw new Exception("You don't have permission to update this store");
        }

        existing.setBrand(storeDTO.getBrand());
        existing.setDescription(storeDTO.getDescription());

        if (storeDTO.getStoreType() != null) {
            existing.setStoreType(storeDTO.getStoreType());
        }

        if (storeDTO.getContact() != null) {
            StoreContact contact = StoreContact.builder()
                    .address(storeDTO.getContact().getAddress())
                    .phone(storeDTO.getContact().getPhone())
                    .email(storeDTO.getContact().getEmail())
                    .build();
            existing.setContact(contact);
        }

        Store updatedStore = storeRepository.save(existing);
        return StoreMapper.tDto(updatedStore);
    }

    @Override
    public void deleteStore(Long id) throws Exception {
        User currentUser = userService.getCurrentUser();

        Store existing = storeRepository.findById(id)
                .orElseThrow(() -> new Exception("Store not found"));

        // SAFETY FIX
        if (existing.getStoreAdmin() == null) {
            throw new Exception("This store has no admin assigned");
        }

        if (!existing.getStoreAdmin().getId().equals(currentUser.getId())) {
            throw new Exception("You don't have permission to delete this store");
        }

        storeRepository.delete(existing);
    }

    @Override
    public StoreDTO getStoreByEmployee() throws Exception {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null || currentUser.getStore() == null) {
            throw new Exception("You don't have permission to access this store");
        }

        return StoreMapper.tDto(currentUser.getStore());
    }

    @Override
    public StoreDTO moderateStore(Long id, StoreStatus status) throws Exception {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new Exception("Store not found"));

        store.setStatus(status);
        Store updatedStore = storeRepository.save(store);

        return StoreMapper.tDto(updatedStore);
    }

    @Override
    public StoreDTO moderateStore(Long id, String status) throws Exception {
        StoreStatus storeStatus;
        try {
            storeStatus = StoreStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid store status: " + status);
        }

        return moderateStore(id, storeStatus);
    }
}
