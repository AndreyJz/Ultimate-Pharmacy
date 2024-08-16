package com.example.farmacymedicine.application;

import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.farmacymedicine.domain.service.FarmacyMedicineService;

import java.util.Optional;

public class FindFarmacyMedicineByIdUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public FindFarmacyMedicineByIdUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public Optional<FarmacyMedicine> execute(int idFarmacy, int idMedicineFartm) {
        return farmacyMedicineService.findById(idFarmacy, idMedicineFartm);
    }
}