package com.example.activeprinciple.aplication;


import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

public class UpdateActivePrincipleUC {
    private final ActivePrincipleService activePrincipleService;

    public UpdateActivePrincipleUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void execute(ActivePrinciple activeIngredient){
        activePrincipleService.updateActivePrinciple(activeIngredient);
    }
}
