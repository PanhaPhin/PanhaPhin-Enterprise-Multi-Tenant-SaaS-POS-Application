package com.logibytekh.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {

    List<Store> findByStoreAdminId(Long adminId);



    
}
