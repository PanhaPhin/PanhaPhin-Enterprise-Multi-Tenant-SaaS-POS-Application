package com.logibytekh.pos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.modal.Customer;
import com.logibytekh.pos.repository.CustomerRespository;
import com.logibytekh.pos.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRespository customerRespository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRespository.save(customer);
        

    }

    @Override
    public Customer updatCustomer(Long id, Customer customer) throws Exception {
        Customer customerToUpdate = customerRespository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found"));

                customer.setFullName(customer.getFullName());
                customer.setEmail(customer.getEmail());
                customer.setPhone(customer.getPhone());

                return customerRespository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) throws Exception {
        Customer customerToUpdate = customerRespository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found"));

        customerRespository.delete(customerToUpdate);
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
       return customerRespository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomer() throws Exception {
       return customerRespository.findAll();
    }

    @Override
    public List<Customer> searchCustomers(String keyword) throws Exception {
      return customerRespository.findbyFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
    }
    
}
