package com.example.modeadministration.aplication;

import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.modeadministration.domain.service.ModeadministrationService;

import java.util.List;

public class ListModeadministrationsUC {
    private final ModeadministrationService modeadministrationService;

    public ListModeadministrationsUC(ModeadministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public List<Modeadministration> execute() {
        return modeadministrationService.findAllModeAdministrations();
    }
}
