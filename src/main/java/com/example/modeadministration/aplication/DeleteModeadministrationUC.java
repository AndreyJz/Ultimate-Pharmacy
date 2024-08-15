package com.example.modeadministration.aplication;

import com.example.modeadministration.domain.service.ModeadministrationService;

public class DeleteModeadministrationUC {
    private final ModeadministrationService modeadministrationService;

    public DeleteModeadministrationUC(ModeadministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public void execute(int id) {
        modeadministrationService.deleteModeAdministration(id);
    }
}

