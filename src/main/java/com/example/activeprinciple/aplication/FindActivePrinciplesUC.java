package com.example.activeprinciple.aplication;

import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

import java.util.List;

public class FindActivePrinciplesUC {
    private final ActivePrincipleService activePrincipleService;

    public FindActivePrinciplesUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public List<ActivePrinciple> execute(){
        return activePrincipleService.findAllActivePrinciple();
    }
}
