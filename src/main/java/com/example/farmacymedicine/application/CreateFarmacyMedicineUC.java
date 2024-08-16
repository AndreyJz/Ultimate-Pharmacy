package com.example.farmacymedicine.application;

import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.farmacymedicine.domain.service.FarmacyMedicineService;

public class CreateFarmacyMedicineUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public CreateFarmacyMedicineUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public void execute(FarmacyMedicine farmacyMedicine) {
        farmacyMedicineService.createFarmacyMedicine(farmacyMedicine);
    }
}