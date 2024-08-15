package com.example.farmacy.application;

import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacy.domain.service.FarmacyService;

import java.util.Optional;

public class FindFarmacyByNameUC {
    private final FarmacyService customerService;

    public FindFarmacyByNameUC(FarmacyService customerService) {
        this.customerService = customerService;
    }

    public Optional<Farmacy> execute(String name) { return customerService.getFarmacyByName(name); }
}
