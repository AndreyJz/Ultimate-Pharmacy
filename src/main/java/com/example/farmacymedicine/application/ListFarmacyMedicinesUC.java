package com.example.farmacymedicine.application;

import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.farmacymedicine.domain.service.FarmacyMedicineService;

import java.util.List;

public class ListFarmacyMedicinesUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public ListFarmacyMedicinesUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public List<FarmacyMedicine> execute() {
        return farmacyMedicineService.findAllFarmacyMedicine();
    }
}