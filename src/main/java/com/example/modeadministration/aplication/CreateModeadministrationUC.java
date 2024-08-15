package com.example.modeadministration.aplication;

import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.modeadministration.domain.service.ModeadministrationService;

public class CreateModeadministrationUC {
    private final ModeadministrationService modeadministrationService;

    public CreateModeadministrationUC(ModeadministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public void execute(Modeadministration modeAdministration) {
        modeadministrationService.createModeAdministration(modeAdministration);
    }
}

