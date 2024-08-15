package com.example.laboratory.application;

import com.example.laboratory.domain.entity.Laboratory;
import com.example.laboratory.domain.service.LaboratoryService;

public class UpdateLaboratoryUC {
    private final LaboratoryService laboratoryService;

    public UpdateLaboratoryUC(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory labatory) {
        laboratoryService.updateLaboratory(labatory);
    }
}