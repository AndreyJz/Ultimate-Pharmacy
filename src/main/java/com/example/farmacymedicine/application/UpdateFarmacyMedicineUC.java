package com.example.farmacymedicine.application;

import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.farmacymedicine.domain.service.FarmacyMedicineService;

public class UpdateFarmacyMedicineUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public UpdateFarmacyMedicineUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public void execute(FarmacyMedicine farmacyMedicine) {
        farmacyMedicineService.updateFarmacyMedicine(farmacyMedicine);
    }
}