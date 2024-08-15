package com.example.medicine.application;

import com.example.medicine.domain.entity.Medicine;
import com.example.medicine.domain.service.MedicineService;

import java.util.Optional;

public class FindMedicineByNameUC {
    private final MedicineService medicineService;

    public FindMedicineByNameUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Optional<Medicine> execute(String name) {
        return medicineService.findMedicineByName(name);
    }
}