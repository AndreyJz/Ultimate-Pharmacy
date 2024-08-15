package com.example.farmacy.domain.service;

import com.example.farmacy.domain.entity.Farmacy;

import java.util.List;
import java.util.Optional;

public interface FarmacyService {
    void createFarmacy(Farmacy customer);
    void updateFarmacy(Farmacy customer);
    void deleteFarmacy(String id);
    Optional<Farmacy> getFarmacyById(String code);
    Optional<Farmacy> getFarmacyByName(String name);
    List<Farmacy> getAllFarmacies();
}
