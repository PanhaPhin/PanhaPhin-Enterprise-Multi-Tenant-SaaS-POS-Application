package com.logibytekh.pos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.modal.Customer;
import com.logibytekh.pos.repository.CustomerRepository;
import com.logibytekh.pos.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        // Ensure fullName is not null
        if (customer.getFullName() == null || customer.getFullName().isBlank()) {
            throw new IllegalArgumentException("Full name cannot be blank");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) throws Exception {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found"));

        customerToUpdate.setFullName(customer.getFullName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());

        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer(Long id) throws Exception {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found"));

        customerRepository.delete(customer);
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
        return customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> searchCustomers(String keyword) {
        return customerRepository
                .findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        keyword, keyword);
    }
}
