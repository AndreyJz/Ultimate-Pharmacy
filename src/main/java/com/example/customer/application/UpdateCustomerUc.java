package com.example.customer.application;

import com.example.customer.domain.entity.Customer;
import com.example.customer.domain.service.CustomerService;

public class UpdateCustomerUc {
    private final CustomerService customerService;

    public UpdateCustomerUc(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) { customerService.updateCustomer(customer); }
}
