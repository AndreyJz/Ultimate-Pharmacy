package com.example.laboratory.application;

import com.example.laboratory.domain.service.LaboratoryService;

public class DeleteLaboratoryUC {
    private final LaboratoryService laboratoryService;

    public DeleteLaboratoryUC(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(int id) {
        laboratoryService.deleteLaboratory(id);
    }
}