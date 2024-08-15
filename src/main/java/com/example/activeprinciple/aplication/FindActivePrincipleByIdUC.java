package com.example.activeprinciple.aplication;


import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

import java.util.Optional;

public class FindActivePrincipleByIdUC {
    private final ActivePrincipleService activePrincipleService;

    public FindActivePrincipleByIdUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public Optional<ActivePrinciple> execute(int id){
        return activePrincipleService.findActivePrincipleById(id);
    }
}
