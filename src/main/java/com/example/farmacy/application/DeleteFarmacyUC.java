package com.example.farmacy.application;

import com.example.farmacy.domain.service.FarmacyService;

public class DeleteFarmacyUC {
    public final FarmacyService customerService;

    public DeleteFarmacyUC(FarmacyService customerService) {
        this.customerService = customerService;
    }

    public void execute(String id) { customerService.deleteFarmacy(id); }
}
