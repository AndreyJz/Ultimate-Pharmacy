package com.example.activeprinciple.aplication;

import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

import java.util.Optional;

public class FindActivePrincipleByNameUC {
    private final ActivePrincipleService activePrincipleService;

    public FindActivePrincipleByNameUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public Optional<ActivePrinciple> execute(String name){
        return activePrincipleService.findActivePrincipleByName(name);
    }
}
