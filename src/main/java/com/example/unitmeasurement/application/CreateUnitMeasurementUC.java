package com.example.unitmeasurement.application;

import com.example.unitmeasurement.domain.entity.UnitMeasurement;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;

public class CreateUnitMeasurementUC {
    private final UnitMeasurementService unitMeasurementService;

    public CreateUnitMeasurementUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void execute(UnitMeasurement unitMeasurement) {
        unitMeasurementService.createUnitMeasurement(unitMeasurement);
    }
}
