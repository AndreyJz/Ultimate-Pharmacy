package com.example.farmacy.application;

import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacy.domain.service.FarmacyService;

import java.util.Optional;

public class FindFarmaciesByIdUC {
    private final FarmacyService customerService;

    public FindFarmaciesByIdUC(FarmacyService customerService) {
        this.customerService = customerService;
    }

    public Optional<Farmacy> execute(String id) { return customerService.getFarmacyById(id); }
}
