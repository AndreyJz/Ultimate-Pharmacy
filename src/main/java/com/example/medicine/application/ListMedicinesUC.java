package com.example.medicine.application;

import com.example.medicine.domain.entity.Medicine;
import com.example.medicine.domain.service.MedicineService;

import java.util.List;

public class ListMedicinesUC {
    private final MedicineService medicineService;

    public ListMedicinesUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public List<Medicine> execute() {
        return medicineService.findAllMedicines();
    }
}