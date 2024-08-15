package com.example.customer.domain.service;

import com.example.customer.domain.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String id);
    Optional<Customer> getCustomerById(String code);
    Optional<Customer> getCustomerByName(String name);
    List<Customer> getAllCustomers();
}
