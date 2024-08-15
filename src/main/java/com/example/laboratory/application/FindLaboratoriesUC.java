package com.example.laboratory.application;

import com.example.laboratory.domain.entity.Laboratory;
import com.example.laboratory.domain.service.LaboratoryService;

import java.util.List;

public class FindLaboratoriesUC {
    private final LaboratoryService laboratoryService;

    public FindLaboratoriesUC(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public List<Laboratory> execute() {
        return laboratoryService.findAllLaboratories();
    }
}
