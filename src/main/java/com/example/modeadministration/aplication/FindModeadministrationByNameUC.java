package com.example.modeadministration.aplication;

import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.modeadministration.domain.service.ModeadministrationService;

import java.util.Optional;

public class FindModeadministrationByNameUC {
    private final ModeadministrationService modeadministrationService;

    public FindModeadministrationByNameUC(ModeadministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public Optional<Modeadministration> execute(String description) {
        return modeadministrationService.findModeAdministrationByDescripcion(description);
    }
}
