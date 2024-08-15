package com.example.customer.application;

import com.example.customer.domain.entity.Customer;
import com.example.customer.domain.service.CustomerService;

public class CreateCustomerUC {
    private final CustomerService customerService;

    public CreateCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) { customerService.createCustomer(customer); }
}
