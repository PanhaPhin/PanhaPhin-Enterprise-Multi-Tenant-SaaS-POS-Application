package com.logibytekh.pos.service;

import java.util.List;

import com.logibytekh.pos.domain.UserRole;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;

public interface  EmployeeService {

    UserDto createStoreEmployee(UserDto employee , Long storeId) throws Exception;
    UserDto createBranchEmployee(UserDto emloyee, Long branchId) throws  Exception; 
    User updateEmployee(Long employeeId, UserDto employeeDetails) throws Exception;
    void deleteEmloyee(Long employeeId);
    List<User> findStoreEmployees(Long storeId, UserRole role) throws Exception;
    List <User> findBranchEmployees(Long branchId, UserRole role) throws Exception;
    


    
}
