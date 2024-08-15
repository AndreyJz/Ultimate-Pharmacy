package com.example.laboratory.application;

import com.example.laboratory.domain.entity.Laboratory;
import com.example.laboratory.domain.service.LaboratoryService;

import java.util.Optional;

public class FindLaboratoryByIdUC {
    private final LaboratoryService laboratoryService;

    public FindLaboratoryByIdUC(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Optional<Laboratory> execute(int id) {
        return laboratoryService.findLaboratoryById(id);
    }
}