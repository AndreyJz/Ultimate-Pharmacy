package com.example.unitmeasurement.application;

import com.example.unitmeasurement.domain.service.UnitMeasurementService;

public class DeleteUnitMeasurementUC {
    private final UnitMeasurementService unitMeasurementService;

    public DeleteUnitMeasurementUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void execute(int id) {
        unitMeasurementService.deleteUnitMeasurement(id);
    }
}
