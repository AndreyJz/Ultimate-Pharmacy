package com.example.medicine.application;

import com.example.medicine.domain.entity.Medicine;
import com.example.medicine.domain.service.MedicineService;

import java.util.Optional;

public class FindMedicineByIdUC {
    private final MedicineService medicineService;

    public FindMedicineByIdUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Optional<Medicine> execute(int id) {
        return medicineService.findMedicineById(id);
    }
}