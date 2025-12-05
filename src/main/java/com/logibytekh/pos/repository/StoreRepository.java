package com.logibytekh.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {

    Store findByStoreAdminId(Long adminId);


    

    
}
