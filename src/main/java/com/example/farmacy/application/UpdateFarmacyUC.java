package com.example.farmacy.application;

import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacy.domain.service.FarmacyService;

public class UpdateFarmacyUC {
    private final FarmacyService customerService;

    public UpdateFarmacyUC(FarmacyService customerService) {
        this.customerService = customerService;
    }

    public void execute(Farmacy customer) { customerService.updateFarmacy(customer); }
}
