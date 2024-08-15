package com.example.activeprinciple.aplication;

import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

public class DeleteActivePrincipleUC {
    private final ActivePrincipleService activePrincipleService;

    public DeleteActivePrincipleUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public ActivePrinciple execute(int id){
        return activePrincipleService.deleteActivePrinciple(id);
    }
}
