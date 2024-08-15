package com.example.farmacy.application;

import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacy.domain.service.FarmacyService;

public class CreateFarmacyUC {
    private final FarmacyService customerService;

    public CreateFarmacyUC(FarmacyService customerService) {
        this.customerService = customerService;
    }

    public void execute(Farmacy customer) { customerService.createFarmacy(customer); }
}
