package com.logibytekh.pos.service;

import java.util.List;

import com.logibytekh.pos.modal.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer updatCustomer(Long id, Customer customer) throws Exception;
    void deleteCustomer (Long id ) throws Exception;
    Customer getCustomer(Long id ) throws Exception;
    List<Customer> getAllCustomer() throws Exception;
    List<Customer> searchCustomers (String keyword) throws Exception;

    
}
