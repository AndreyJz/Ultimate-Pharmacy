package com.example.medicine.application;

import com.example.medicine.domain.entity.Medicine;
import com.example.medicine.domain.service.MedicineService;

public class UpdateMedicineUC {
    private final MedicineService medicineService;

    public UpdateMedicineUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Medicine medicine) {
        medicineService.updateMedicine(medicine);
    }
}