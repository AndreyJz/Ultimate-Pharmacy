package com.example.medicine.application;

import com.example.medicine.domain.service.MedicineService;

public class DeleteMedicineUC {
    private final MedicineService medicineService;

    public DeleteMedicineUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(int id) {
        medicineService.deleteMedicine(id);
    }
}