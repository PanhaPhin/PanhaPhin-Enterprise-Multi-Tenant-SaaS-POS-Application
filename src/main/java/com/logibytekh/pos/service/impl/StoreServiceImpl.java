package com.logibytekh.pos.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.checkerframework.checker.units.qual.radians;
import org.springframework.stereotype.Service;

import com.logibytekh.pos.mapper.StoreMapper;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.StoreContact;
import com.logibytekh.pos.modal.StoreContact.StoreContactBuilder;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.StoreDTO;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.service.StoreService;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final UserService userService;


      @Override
    public StoreDTO createStore(StoreDTO storeDTO, User user) {
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
       List<Store> dtos= storeRepository.findAll();

       return dtos.stream().map(StoreMapper::tDto).collect(Collectors.toList());


    }

    @Override
    public Store getStoreByAdmin() throws Exception{
        User admin=userService.getCurrentUser();
       return storeRepository.findByStoreAdminId(admin.getId());
    }




   

    @Override
public StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception {
    User currentUser = userService.getCurrentUser();

    Store existing = storeRepository.findByStoreAdminId(currentUser.getId());

    if (existing == null) {
        throw new Exception("store not found");
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
        Store store= getStoreByAdmin();
       storeRepository.delete(store);
    }

    @Override
    public StoreDTO getStoreByEmployee() throws Exception {
        User currentUser=userService.getCurrentUser();

        if(currentUser==null){
            throw new Exception("you don't have permission to access this store");
        }

       return StoreMapper.tDto(currentUser.getStore());
    }
    
}


