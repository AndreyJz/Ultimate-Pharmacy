package com.example.medicine.domain.service;

import com.example.medicine.domain.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    void createMedicine(Medicine medicine);
    void updateMedicine(Medicine medicine);
    void deleteMedicine(int id);
    Optional<Medicine> findMedicineById(int id);
    Optional<Medicine> findMedicineByName(String name);
    List<Medicine> findAllMedicines();
}
