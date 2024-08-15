package com.example;

import com.example.activeprinciple.aplication.*;
import com.example.activeprinciple.domain.service.ActivePrincipleService;
import com.example.activeprinciple.infrastructure.ActivePrincipleController;
import com.example.activeprinciple.infrastructure.ActivePrincipleRepository;
import com.example.city.aplication.*;
import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;
import com.example.city.infrastructure.controller.CityController;
import com.example.city.infrastructure.repository.CityRepository;
import com.example.country.aplication.*;
import com.example.country.domain.service.CountryService;
import com.example.country.infrastructure.controller.CountryController;
import com.example.country.infrastructure.repository.CountryRepository;
import com.example.customer.application.CreateCustomerUC;
import com.example.customer.application.FindCustomerByNameUC;
import com.example.customer.application.ListAllCustomersUC;
import com.example.customer.application.UpdateCustomerUc;
import com.example.customer.domain.service.CustomerService;
import com.example.customer.infrastructure.controller.CustomerController;
import com.example.customer.infrastructure.repository.CustomerRepository;
import com.example.farmacy.application.CreateFarmacyUC;
import com.example.farmacy.application.FindFarmacyByNameUC;
import com.example.farmacy.application.ListAllFarmaciesUC;
import com.example.farmacy.application.UpdateFarmacyUC;
import com.example.farmacy.domain.service.FarmacyService;
import com.example.farmacy.infrastructure.controller.FarmacyController;
import com.example.farmacy.infrastructure.repository.FarmacyRepository;
import com.example.infrastructure.controller.PharmacyController;
import com.example.laboratory.application.*;
import com.example.laboratory.domain.service.LaboratoryService;
import com.example.laboratory.infrastructure.controller.LaboratoryController;
import com.example.laboratory.infrastructure.repository.LaboratoryRepository;
import com.example.modeadministration.aplication.*;
import com.example.modeadministration.domain.service.ModeadministrationService;
import com.example.modeadministration.infrastructure.controller.ModeAdministrationController;
import com.example.modeadministration.infrastructure.repository.ModeAdministrationRepository;
import com.example.region.aplication.*;
import com.example.region.domain.service.RegionService;
import com.example.region.infrastructure.controller.RegionController;
import com.example.region.infrastructure.repository.RegionRepository;
import com.example.unitmeasurement.application.*;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;
import com.example.unitmeasurement.infrastructure.controller.UnitMeasurementController;
import com.example.unitmeasurement.infrastructure.repository.UnitMeasurementRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PharmacyController pc = new PharmacyController();
    }
}