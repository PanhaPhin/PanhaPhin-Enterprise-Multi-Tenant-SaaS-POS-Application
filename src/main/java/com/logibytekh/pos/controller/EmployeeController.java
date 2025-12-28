package com.logibytekh.pos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.domain.UserRole;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.UserDto;
import com.logibytekh.pos.payload.response.ApiResponse;
import com.logibytekh.pos.service.EmployeeService;
import com.stripe.net.ApiResource;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/store/{storeId}")
    public ResponseEntity<UserDto> createStoreEmployee(
            @PathVariable Long storeId,
            @RequestBody UserDto userDto) throws Exception {
        UserDto employee = employeeService.createStoreEmployee(userDto, storeId);

        return ResponseEntity.ok(employee);

    }

    @PostMapping("/branch/{branchId}")
    public ResponseEntity<UserDto> createBranchEmployee(
            @PathVariable Long branchId,
            @RequestBody UserDto userDto) throws Exception {
        UserDto employee = employeeService.createBranchEmployee(userDto, branchId);
        return ResponseEntity.ok(employee);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateEmployee(
            @PathVariable Long id,
            @RequestBody UserDto userDto) throws Exception {
        User employee = employeeService.updateEmployee(id, userDto);
        return ResponseEntity.ok(employee);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(
            @PathVariable Long id
    )throws Exception {
                employeeService.deleteEmloyee(id);
                ApiResponse apiResponse = new ApiResponse();
                apiResponse.setMessage("Employee deleted");
                return ResponseEntity.ok(apiResponse);
    }


     @GetMapping("/store/{id}")
    public ResponseEntity<List<UserDto>> storeEmployee(
            @PathVariable Long id,
            @RequestParam(required = false) UserRole userRole) throws Exception {
        List<UserDto> employee = employeeService.findStoreEmployees(id, userRole);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/branch/{id}")
    public ResponseEntity<List<UserDto>> branchEmployee(
            @PathVariable Long id,
            @RequestParam (required = false) UserRole userRole ) throws Exception {
                List<UserDto> employee = employeeService.findStoreEmployees(id, userRole);
        return ResponseEntity.ok(employee);

    }

}