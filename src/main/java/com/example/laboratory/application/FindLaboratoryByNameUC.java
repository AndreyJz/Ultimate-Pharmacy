package com.example.laboratory.application;

import com.example.laboratory.domain.entity.Laboratory;
import com.example.laboratory.domain.service.LaboratoryService;

import java.util.Optional;

public class FindLaboratoryByNameUC {
    private final LaboratoryService laboratoryService;

    public FindLaboratoryByNameUC(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Optional<Laboratory> execute(String name) {
        return laboratoryService.findLaboratoryByName(name);
    }
}