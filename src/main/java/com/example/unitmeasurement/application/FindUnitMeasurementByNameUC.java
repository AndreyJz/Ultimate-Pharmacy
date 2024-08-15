package com.example.unitmeasurement.application;

import com.example.unitmeasurement.domain.entity.UnitMeasurement;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;

import java.util.Optional;

public class FindUnitMeasurementByNameUC {
    private final UnitMeasurementService unitMeasurementService;

    public FindUnitMeasurementByNameUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public Optional<UnitMeasurement> execute(String name) {
        return unitMeasurementService.findUnitMeasurementByName(name);
    }
}
