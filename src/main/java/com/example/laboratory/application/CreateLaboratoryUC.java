package com.example.laboratory.application;

import com.example.laboratory.domain.entity.Laboratory;
import com.example.laboratory.domain.service.LaboratoryService;

import java.util.List;
import java.util.Optional;

public class CreateLaboratoryUC {
    private final LaboratoryService laboratoryService;

    public CreateLaboratoryUC(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory labatory) {
        laboratoryService.createLaboratory(labatory);
    }
}