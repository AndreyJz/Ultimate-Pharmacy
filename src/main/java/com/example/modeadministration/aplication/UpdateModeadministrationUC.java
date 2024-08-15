package com.example.modeadministration.aplication;

import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.modeadministration.domain.service.ModeadministrationService;

public class UpdateModeadministrationUC {
    private final ModeadministrationService modeadministrationService;

    public UpdateModeadministrationUC(ModeadministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public void execute(Modeadministration modeadministration) {
        modeadministrationService.updateModeAdministration(modeadministration);
    }
}
