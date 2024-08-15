package com.example.medicine.application;

import com.example.medicine.domain.entity.Medicine;
import com.example.medicine.domain.service.MedicineService;

import java.util.List;
import java.util.Optional;

public class CreateMedicineUC {
    private final MedicineService medicineService;

    public CreateMedicineUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Medicine medicine) {
        medicineService.createMedicine(medicine);
    }
}