package com.example.laboratory.domain.service;

import com.example.laboratory.domain.entity.Laboratory;

import java.util.List;
import java.util.Optional;

public interface LaboratoryService {
    void createLaboratory(Laboratory laboratory);
    void updateLaboratory(Laboratory laboratory);
    void deleteLaboratory(int id);
    Optional<Laboratory> findLaboratoryById(int id);
    List<Laboratory> findAllLaboratories();
    Optional<Laboratory> findLaboratoryByName(String name);
}
