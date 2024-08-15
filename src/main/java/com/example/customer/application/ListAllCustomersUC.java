package com.example.customer.application;

import com.example.customer.domain.entity.Customer;
import com.example.customer.domain.service.CustomerService;

import java.util.List;

public class ListAllCustomersUC {
    private final CustomerService customerService;

    public ListAllCustomersUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> execute() { return customerService.getAllCustomers(); }
}
