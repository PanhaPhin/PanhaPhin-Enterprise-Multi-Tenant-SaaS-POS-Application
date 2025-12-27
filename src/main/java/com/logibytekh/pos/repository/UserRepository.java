package com.logibytekh.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    List<User> findByStore(Store store);
    List<User> findByBranchId(Long branchId);

    
}
