package com.example.farmacymedicine.application;

import com.example.farmacymedicine.domain.service.FarmacyMedicineService;

public class DeleteFarmacyMedicineUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public DeleteFarmacyMedicineUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public void execute(int idFarmacy, int idMedicineFartm) {
        farmacyMedicineService.deleteFarmacyMedicine(idFarmacy, idMedicineFartm);
    }
}