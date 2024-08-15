package com.example.customer.application;

import com.example.customer.domain.service.CustomerService;

public class DeleteCustomerUC {
    public final CustomerService customerService;

    public DeleteCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(String id) { customerService.deleteCustomer(id); }
}
