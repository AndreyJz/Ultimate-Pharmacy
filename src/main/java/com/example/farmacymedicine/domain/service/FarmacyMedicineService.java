package com.example.farmacymedicine.domain.service;

import com.example.farmacymedicine.domain.entity.FarmacyMedicine;

import java.util.List;
import java.util.Optional;

public interface FarmacyMedicineService {
    void createFarmacyMedicine(FarmacyMedicine farmacyMedicine);
    void updateFarmacyMedicine(FarmacyMedicine farmacyMedicine);
    void deleteFarmacyMedicine(int idFarmacy, int idMedicineFartm);
    Optional<FarmacyMedicine> findById(int idFarmacy, int idMedicineFartm);
    List<FarmacyMedicine> findAllFarmacyMedicine();
}
