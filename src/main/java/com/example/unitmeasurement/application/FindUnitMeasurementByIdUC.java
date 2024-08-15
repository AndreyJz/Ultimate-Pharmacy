package com.example.unitmeasurement.application;

import com.example.unitmeasurement.domain.entity.UnitMeasurement;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;

import java.util.Optional;

public class FindUnitMeasurementByIdUC {
    private final UnitMeasurementService unitMeasurementService;

    public FindUnitMeasurementByIdUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public Optional<UnitMeasurement> execute(int id) {
        return unitMeasurementService.findUnitMeasurementById(id);
    }
}
