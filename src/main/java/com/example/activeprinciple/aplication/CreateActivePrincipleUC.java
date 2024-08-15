package com.example.activeprinciple.aplication;


import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

public class CreateActivePrincipleUC {
    private final ActivePrincipleService activePrincipleService;

    public CreateActivePrincipleUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }
    
    public void execute(ActivePrinciple activePrinciple) {
        activePrincipleService.createActivePrinciple(activePrinciple);
    }
    
}
