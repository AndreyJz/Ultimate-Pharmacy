package com.example.customer.application;

import com.example.customer.domain.entity.Customer;
import com.example.customer.domain.service.CustomerService;

import java.util.Optional;

public class FindCustomersByIdUC {
    private final CustomerService customerService;

    public FindCustomersByIdUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> execute(String id) { return customerService.getCustomerById(id); }
}
