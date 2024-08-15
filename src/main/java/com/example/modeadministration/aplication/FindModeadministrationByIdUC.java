package com.example.modeadministration.aplication;

import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.modeadministration.domain.service.ModeadministrationService;

import java.util.Optional;

public class FindModeadministrationByIdUC {
    private final ModeadministrationService modeadministrationService;

    public FindModeadministrationByIdUC(ModeadministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public Optional<Modeadministration> execute(int id) {
        return modeadministrationService.findModeAdministrationById(id);
    }
}

