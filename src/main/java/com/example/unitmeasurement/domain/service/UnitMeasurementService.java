package com.example.unitmeasurement.domain.service;

import com.example.unitmeasurement.domain.entity.UnitMeasurement;

import java.util.List;
import java.util.Optional;

public interface UnitMeasurementService {
    void createUnitMeasurement(UnitMeasurement unitMeasurement);
    void updateUnitMeasurement(UnitMeasurement unitMeasurement);
    void deleteUnitMeasurement(int id);
    Optional<UnitMeasurement> findUnitMeasurementById(int id);
    List<UnitMeasurement> findAllUnitMeasurements();
    Optional<UnitMeasurement> findUnitMeasurementByName(String name);
}
