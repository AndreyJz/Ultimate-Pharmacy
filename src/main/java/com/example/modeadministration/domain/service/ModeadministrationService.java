package com.example.modeadministration.domain.service;

import com.example.modeadministration.domain.entity.Modeadministration;

import java.util.List;
import java.util.Optional;

public interface ModeadministrationService {
    void createModeAdministration(Modeadministration modeAdministration);
    void updateModeAdministration(Modeadministration modeAdministration);
    void deleteModeAdministration(int id);
    Optional<Modeadministration> findModeAdministrationById(int id);
    Optional<Modeadministration> findModeAdministrationByDescripcion(String name);
    List<Modeadministration> findAllModeAdministrations();
}
