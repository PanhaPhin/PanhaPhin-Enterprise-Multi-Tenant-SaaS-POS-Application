package com.logibytekh.pos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.domain.UserRole;
import com.logibytekh.pos.mapper.UserMapper;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;
import com.logibytekh.pos.repository.BranchRespository;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.repository.UserRepository;
import com.logibytekh.pos.service.EmployeeService;

import org.springframework.security.crypto.password.PasswordEncoder;






import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeeService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final BranchRespository branchRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createStoreEmployee(UserDto employee, Long storeId) throws Exception {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new Exception("Store not found")

        );
        Branch branch = null;

        if (employee.getRole() == UserRole.ROLE_BRANCH_MANAGER) {
            if (employee.getBranchId() == null) {
                throw new Exception("branch id is required to create branch manager");
            }
            branch = branchRepository.findById(employee.getBranchId()).orElseThrow(
                    () -> new Exception("branch not found")

            );

        }
        User user = UserMapper.toEntity(employee);
        user.setStore(store);
        user.setBranch(branch);
        user.setPassword(passwordEncoder.encode(employee.getPassword()));

        User savedEmployee = userRepository.save(user);
        if (employee.getRole() == UserRole.ROLE_STORE_MANAGER) {
            branch.setManager(savedEmployee);
            branchRepository.save(branch);
            
        }


        return UserMapper.toDto(savedEmployee);
    }

    @Override
    public UserDto createBranchEmployee(UserDto emloyee, Long branchId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User updateEmployee(Long employeeId, User employeeDetails) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteEmloyee(Long employeeId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findStoreEmployees(Long storeId, UserRole role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findBranchEmployees(Long branchId, UserRole role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
