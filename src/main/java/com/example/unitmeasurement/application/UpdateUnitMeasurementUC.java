package com.example.unitmeasurement.application;

import com.example.unitmeasurement.domain.entity.UnitMeasurement;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;

public class UpdateUnitMeasurementUC {
    private final UnitMeasurementService unitMeasurementService;

    public UpdateUnitMeasurementUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void execute(UnitMeasurement unitMeasurement) {
        unitMeasurementService.updateUnitMeasurement(unitMeasurement);
    }
}
