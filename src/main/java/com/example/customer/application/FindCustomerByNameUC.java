package com.example.customer.application;

import com.example.customer.domain.entity.Customer;
import com.example.customer.domain.service.CustomerService;

import java.util.Optional;

public class FindCustomerByNameUC {
    private final CustomerService customerService;

    public FindCustomerByNameUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> execute(String name) { return customerService.getCustomerByName(name); }
}
