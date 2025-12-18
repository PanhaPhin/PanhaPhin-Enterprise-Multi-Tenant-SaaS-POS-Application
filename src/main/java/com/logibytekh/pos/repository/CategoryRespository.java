package com.logibytekh.pos.repository;

import com.logibytekh.pos.modal.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;  

public interface  CategoryRespository extends JpaRepository<Category, Long> {

    List<Category> findByStoreId(Long storeId);
    
}
