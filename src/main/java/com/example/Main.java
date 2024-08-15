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
//        ModeAdministrationRepository modeAdminRepo = new ModeAdministrationRepository();
//        FindModeadministrationByNameUC findByNameUC = new FindModeadministrationByNameUC(modeAdminRepo);
//        ListModeadministrationsUC listModesUC = new ListModeadministrationsUC(modeAdminRepo);
//        CreateModeadministrationUC createModeUC = new CreateModeadministrationUC(modeAdminRepo);
//
//        ModeAdministrationController modeAdminController = new ModeAdministrationController(createModeUC, findByNameUC, listModesUC);
//
//        modeAdminController.createModeAdministration();

        LaboratoryService ls = new LaboratoryRepository();
        CityService ccs = new CityRepository();
//        CreateLaboratoryUC cl = new CreateLaboratoryUC(ls);
//        FindCitiesUC fc = new FindCitiesUC(ccs);
//        FindCityByNameUC fcn = new FindCityByNameUC(ccs);
//        LaboratoryController lc = new LaboratoryController(cl, fc, fcn);
//        lc.createLaboratory();

//        UpdateLaboratoryUC uc = new UpdateLaboratoryUC(ls);
//        FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
//        FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
//        FindCitiesUC fc = new FindCitiesUC(ccs);
//        FindCityByNameUC fcn = new FindCityByNameUC(ccs);
//        LaboratoryController lc = new LaboratoryController(uc,fl,fln,fc,fcn);
//        lc.updateLaboratory();

//        DeleteLaboratoryUC dl = new DeleteLaboratoryUC(ls);
//        FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
//        FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
//        LaboratoryController lc = new LaboratoryController(dl,fl,fln);
//        lc.deleteLaboratory();

//        FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
//        LaboratoryController lc = new LaboratoryController(fl);
//        lc.ListLaboratories();

        CustomerService ccss = new CustomerRepository();
        UpdateCustomerUc cc = new UpdateCustomerUc(ccss);
        ListAllCustomersUC lc = new ListAllCustomersUC(ccss);
        FindCustomerByNameUC fccn = new FindCustomerByNameUC(ccss);
        FindCitiesUC fc = new FindCitiesUC(ccs);
        FindCityByNameUC fcn = new FindCityByNameUC(ccs);
        FindCityByIdUC fcnd = new FindCityByIdUC(ccs);
        CustomerController c = new CustomerController(cc,lc,fccn,fc,fcn,fcnd);
        c.updateCustomer();




    }
}