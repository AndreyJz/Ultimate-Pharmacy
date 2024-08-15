package com.example.activeprinciple.domain.service;

import com.example.activeprinciple.domain.entity.ActivePrinciple;

import java.util.List;
import java.util.Optional;

public interface ActivePrincipleService {
    void createActivePrinciple(ActivePrinciple ActivePrinciple);
    void updateActivePrinciple(ActivePrinciple ActivePrinciple);
    ActivePrinciple deleteActivePrinciple(int id);
    Optional<ActivePrinciple> findActivePrincipleById(int id);
    List<ActivePrinciple> findAllActivePrinciple();
    Optional<ActivePrinciple> findActivePrincipleByName(String name);
}
