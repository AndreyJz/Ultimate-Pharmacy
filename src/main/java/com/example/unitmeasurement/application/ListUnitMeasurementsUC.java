package com.example.unitmeasurement.application;

import com.example.unitmeasurement.domain.entity.UnitMeasurement;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;

import java.util.List;

public class ListUnitMeasurementsUC {
    private final UnitMeasurementService unitMeasurementService;

    public ListUnitMeasurementsUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public List<UnitMeasurement> execute() {
        return unitMeasurementService.findAllUnitMeasurements();
    }
}
