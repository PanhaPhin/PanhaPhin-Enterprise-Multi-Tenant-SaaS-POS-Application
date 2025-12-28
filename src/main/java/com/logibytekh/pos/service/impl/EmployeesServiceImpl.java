package com.logibytekh.pos.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public UserDto createBranchEmployee(UserDto employee, Long branchId) throws Exception {

        Branch branch = branchRepository.findById(branchId).orElseThrow(
                () -> new Exception("Branch not found")

        );

        if (employee.getRole() != UserRole.ROLE_BRAMCH_CASHIHER || employee.getRole() != UserRole.ROLE_STORE_MANAGER) {

            User user = UserMapper.toEntity(employee);
            user.setBranch(branch);
            user.setPassword(passwordEncoder.encode(employee.getPassword()));
            return UserMapper.toDto(userRepository.save(user));

        }
        throw new Exception("Invalid role for branch employee");

    }

    @Override
    public User updateEmployee(Long employeeId, UserDto employeeDetails) throws Exception {

        User existingEmployee = userRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Employee not found"));

        Branch branch = branchRepository.findById(employeeDetails.getBranchId()).orElseThrow(
                () -> new Exception("Branch not found")

        );

        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setFullName(employeeDetails.getFullName());
        existingEmployee.setPassword(employeeDetails.getPassword());
        existingEmployee.setRole(employeeDetails.getRole());
        existingEmployee.setBranch(branch);
        return userRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmloyee(Long employeeId) {
        User employee = userRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Employee not found"));
        userRepository.delete(employee);
    }

    @Override
    public List<UserDto> findStoreEmployees(Long storeId, UserRole role) throws Exception {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new Exception("Store not found")

        );
        return userRepository.findByStore(store).stream().filter(
                user -> role == null || user.getRole() == role)
                .map(UserMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<UserDto> findBranchEmployees(Long branchId, UserRole role) throws Exception {

        Branch branch = branchRepository.findById(branchId).orElseThrow(
                () -> new RuntimeException("Branch not found")

        );

        List<User> employee = userRepository.findByBranchId(branchId)
                .stream().filter(
                        user -> role == null || user.getRole() == role)
                .collect(Collectors.toList());

        return List.of();
    }

}
