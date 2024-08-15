package com.example.farmacy.application;

import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacy.domain.service.FarmacyService;

import java.util.List;

public class ListAllFarmaciesUC {
    private final FarmacyService customerService;

    public ListAllFarmaciesUC(FarmacyService customerService) {
        this.customerService = customerService;
    }

    public List<Farmacy> execute() { return customerService.getAllFarmacies(); }
}
