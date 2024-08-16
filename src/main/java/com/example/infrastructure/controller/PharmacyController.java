package com.example.infrastructure.controller;

import com.example.activeprinciple.aplication.*;
import com.example.activeprinciple.domain.service.ActivePrincipleService;
import com.example.activeprinciple.infrastructure.ActivePrincipleController;
import com.example.activeprinciple.infrastructure.ActivePrincipleRepository;
import com.example.customer.application.*;
import com.example.customer.domain.service.CustomerService;
import com.example.customer.infrastructure.controller.CustomerController;
import com.example.customer.infrastructure.repository.CustomerRepository;
import com.example.farmacy.domain.service.FarmacyService;
import com.example.farmacy.infrastructure.controller.FarmacyController;
import com.example.farmacy.application.*;
import com.example.farmacy.infrastructure.repository.FarmacyRepository;
import com.example.farmacymedicine.application.*;
import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.farmacymedicine.domain.service.FarmacyMedicineService;
import com.example.farmacymedicine.infrastructure.controller.FarmacyMedicineController;
import com.example.farmacymedicine.infrastructure.repository.FarmacyMedicineRepository;
import com.example.laboratory.application.*;
import com.example.laboratory.domain.service.LaboratoryService;
import com.example.laboratory.infrastructure.controller.LaboratoryController;
import com.example.laboratory.infrastructure.repository.LaboratoryRepository;
import com.example.medicine.application.*;
import com.example.medicine.domain.service.MedicineService;
import com.example.medicine.infrastructure.controller.MedicineController;
import com.example.medicine.infrastructure.repository.MedicineRepository;
import com.example.modeadministration.aplication.*;
import com.example.unitmeasurement.application.*;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;
import com.example.unitmeasurement.infrastructure.controller.UnitMeasurementController;
import com.example.unitmeasurement.infrastructure.repository.UnitMeasurementRepository;
import com.example.city.aplication.*;
import com.example.city.domain.service.CityService;
import com.example.city.infrastructure.repository.CityRepository;
import com.example.city.infrastructure.controller.CityController;
import com.example.country.aplication.*;
import com.example.country.domain.service.CountryService;
import com.example.country.infrastructure.repository.CountryRepository;
import com.example.country.infrastructure.controller.CountryController;
import com.example.modeadministration.domain.service.ModeadministrationService;
import com.example.modeadministration.infrastructure.controller.ModeAdministrationController;
import com.example.modeadministration.infrastructure.repository.ModeAdministrationRepository;
import com.example.region.aplication.*;
import com.example.region.domain.service.RegionService;
import com.example.region.infrastructure.repository.RegionRepository;
import com.example.region.infrastructure.controller.RegionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PharmacyController extends JFrame implements ActionListener {
    private static final String CREATE = "Create";
    private static final String LIST = "List";
    private static final String SEARCH = "Search";
    private static final String UPDATE = "Update";
    private static final String DELETE = "Delete";
    private static final String EXIT = "Exit";

    private Map<String, JPanel> panels;
    private Map<String, JButton> buttons;

    private JPanel mainMenuPanel;
    private JPanel contentPanel;

    public PharmacyController() {
        initializeController();
    }

    private void initializeController() {
        setTitle("Pharmacy Menu");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panels = new HashMap<>();
        buttons = new HashMap<>();

        setLayout(new BorderLayout());

        mainMenuPanel = new JPanel(new GridLayout(0,2,25,50));
        mainMenuPanel.setBounds(50,25,750,450);
        initializeMainPanel();
        add(mainMenuPanel);

        contentPanel = new JPanel(new CardLayout());
        initializeSubPanels();
        add(contentPanel, BorderLayout.CENTER);
        contentPanel.setVisible(false);

        setVisible(true);
    }

    private void initializeMainPanel() {
        String[] mainOptions = {"Country", "City", "Region", "Laboratory", "Customer", "ModeAdministration", "ActivePrinciple", "UnitMeasurement", "Farmacy", "Medicine", "Farmacy-Medicine"};
        for (String option : mainOptions) {
            addButton(mainMenuPanel, option, this);
        }
    }

    private void initializeSubPanels() {
        String[] entities = {"Country", "City", "Region", "Laboratory", "Customer", "ModeAdministration", "ActivePrinciple", "UnitMeasurement", "Farmacy", "Medicine", "Farmacy-Medicine"};
        for (String entity : entities) {
            JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
            addEntityButtons(panel, entity);
            panels.put(entity, panel);
            contentPanel.add(panel, entity);
        }
    }

    private void addEntityButtons(JPanel panel, String entity) {
        addButton(panel, CREATE + " " + entity, this);
        addButton(panel, LIST + " " + entity, this);
        addButton(panel, SEARCH + " " + entity, this);
        addButton(panel, UPDATE + " " + entity, this);
        addButton(panel, DELETE + " " + entity, this);
        addButton(panel, EXIT, this);
    }

    private void addButton(JPanel panel, String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setBackground(Color.LIGHT_GRAY);

        ImageIcon icon = new ImageIcon();

        if (text.trim().contains("Create")) {
            icon = new ImageIcon(new ImageIcon("src/images/create-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        } else if (text.startsWith(LIST)) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/images/create-svgrepo-com (2).svg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        } else if (text.startsWith(SEARCH)) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/images/find-on-map-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        } else if (text.startsWith(UPDATE)) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/images/create-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        } else if (text.startsWith(DELETE)) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/images/icons8-basura.svg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        } else if (text.startsWith(EXIT)) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/images/house-shape-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        }

        icon = new ImageIcon(new ImageIcon("src/main/resources/images/45069.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        button.setIcon(icon);
        icon = new ImageIcon(new ImageIcon("src/main/resources/images/create-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

        button.setIcon(icon);
        button.addActionListener(listener);
        panel.add(button);
        buttons.put(text, button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (panels.containsKey(command)) {
            showPanel(command);
        } else if (command.startsWith(CREATE)) {
            handleCreate(command.split(" ")[1]);
        } else if (command.startsWith(LIST)) {
            handleList(command.split(" ")[1]);
        } else if (command.startsWith(SEARCH)) {
            handleSearch(command.split(" ")[1]);
        } else if (command.startsWith(UPDATE)) {
            handleUpdate(command.split(" ")[1]);
        } else if (command.startsWith(DELETE)) {
            handleDelete(command.split(" ")[1]);
        } else if (command.equals(EXIT)) {
            showPanel("MAIN");  // Volver al panel principal en lugar de salir
            contentPanel.setVisible(false);
            mainMenuPanel.setVisible(true);
        }
    }

    private void showPanel(String panelName) {
        contentPanel.setVisible(true);
        mainMenuPanel.setVisible(false);
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
        System.out.println("Showing panel: " + panelName);  // Depuración
    }

    RegionService rs = new RegionRepository();
    CityService cs = new CityRepository();
    CountryService ccs = new CountryRepository();
    UnitMeasurementService us = new UnitMeasurementRepository();
    ActivePrincipleService as = new ActivePrincipleRepository();
    LaboratoryService ls = new LaboratoryRepository();
    ModeadministrationService ms = new ModeAdministrationRepository();
    FarmacyService fs = new FarmacyRepository();
    CustomerService ccss = new CustomerRepository();
    MedicineService mss = new MedicineRepository();
    FarmacyMedicineService fms = new FarmacyMedicineRepository();

    private void handleCreate(String entity) {
        if (entity.equals("Country")) {
            CreateCountryUC cc = new CreateCountryUC(ccs);
            CountryController ccc = new CountryController(cc);
            ccc.CreateCountry();
        } else if (entity.equals("City")) {
            CreateCityUC cc = new CreateCityUC(cs);
            FindRegionByNameUC frn = new FindRegionByNameUC(rs);
            ListRegionsUC lr = new ListRegionsUC(rs);
            CityController ccc = new CityController(cc,lr,frn);
            ccc.createCity();
        } else if (entity.equals("Region")) {
            CreateRegionUC uc = new CreateRegionUC(rs);
            FindCountryByNameUC fc = new FindCountryByNameUC(ccs);
            ListAllCountriesUC lc = new ListAllCountriesUC(ccs);
            RegionController c = new RegionController(uc,fc,lc);
            c.createRegion();
        } else if (entity.equals("Laboratory")) {
            CreateLaboratoryUC cl = new CreateLaboratoryUC(ls);
            FindCitiesUC fc = new FindCitiesUC(cs);
            FindCityByNameUC fcn = new FindCityByNameUC(cs);
            LaboratoryController lc = new LaboratoryController(cl, fc, fcn);
            lc.createLaboratory();
        } else if (entity.equals("Customer")) {
            CreateCustomerUC cc = new CreateCustomerUC(ccss);
            FindCitiesUC fc = new FindCitiesUC(cs);
            FindCityByNameUC fcn = new FindCityByNameUC(cs);
            CustomerController c = new CustomerController(cc,fc,fcn);
            c.createMedicine();
        } else if (entity.equals("ModeAdministration")) {
            CreateModeadministrationUC cm = new CreateModeadministrationUC(ms);
            ModeAdministrationController mc = new ModeAdministrationController(cm);
            mc.createModeAdministration();
        } else if (entity.equals("ActivePrinciple")) {
            CreateActivePrincipleUC ca = new CreateActivePrincipleUC(as);
            ActivePrincipleController ac = new ActivePrincipleController(ca);
            ac.CreateActivePrinciple();
        } else if (entity.equals("UnitMeasurement")) {
            UnitMeasurementService us = new UnitMeasurementRepository();
            CreateUnitMeasurementUC cu = new CreateUnitMeasurementUC(us);
            UnitMeasurementController uc = new UnitMeasurementController(cu);
            uc.createUnitMeasurement();
        } else if (entity.equals("Farmacy")) {
            CreateFarmacyUC cf = new CreateFarmacyUC(fs);
            FindCitiesUC fc = new FindCitiesUC(cs);
            FindCityByNameUC fcn = new FindCityByNameUC(cs);
            FarmacyController c = new FarmacyController(cf,fc,fcn);
            c.createFarmacy();
        } else if (entity.equals("Medicine")) {
            CreateMedicineUC mc = new CreateMedicineUC(mss);
            ListModeadministrationsUC lm = new ListModeadministrationsUC(ms);
            ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
            FindActivePrinciplesUC fp = new FindActivePrinciplesUC(as);
            FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
            FindModeadministrationByNameUC fmn = new FindModeadministrationByNameUC(ms);
            FindUnitMeasurementByNameUC fumn = new FindUnitMeasurementByNameUC(us);
            FindActivePrincipleByNameUC fapn = new FindActivePrincipleByNameUC(as);
            FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
            MedicineController c = new MedicineController(mc,lm,lu,fp,fl,fmn,fumn,fapn,fln);
            c.createMedicine();
        } else if (entity.equals("Farmacy-Medicine")) {
            CreateFarmacyMedicineUC cfm = new CreateFarmacyMedicineUC(fms);
            ListMedicinesUC lm = new ListMedicinesUC(mss);
            ListAllFarmaciesUC lf = new ListAllFarmaciesUC(fs);
            FindMedicineByNameUC fmn = new FindMedicineByNameUC(mss);
            FindFarmacyByNameUC ffn = new FindFarmacyByNameUC(fs);
            FarmacyMedicineController c = new FarmacyMedicineController(cfm,lm,lf,fmn,ffn);
            c.createFarmacyMedicine();
        }
    }

    private void handleList(String entity) {
        if (entity.equals("Country")) {
            ListAllCountriesUC fcsuc = new ListAllCountriesUC(ccs);
            CountryController uiCountry = new CountryController(fcsuc);
            uiCountry.ListCountries();
        } else if (entity.equals("City")) {
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            CityController uiCity = new CityController(fcsuc);
            uiCity.ListCities();
        } else if (entity.equals("Region")) {
            ListRegionsUC fnsuc = new ListRegionsUC(rs);
            RegionController uiRegion = new RegionController(fnsuc);
            uiRegion.ListRegions();
        } else if (entity.equals("Laboratory")) {
            FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
            LaboratoryController lc = new LaboratoryController(fl);
            lc.ListLaboratories();
        } else if (entity.equals("Customer")) {
            ListAllCustomersUC fcsuc = new ListAllCustomersUC(ccss);
            CustomerController c = new CustomerController(fcsuc);
            c.ListCustomers();
        } else if (entity.equals("ModeAdministration")) {
            ModeadministrationService ms = new ModeAdministrationRepository();
            ListModeadministrationsUC fcsuc = new ListModeadministrationsUC(ms);
            ModeAdministrationController uiCountry = new ModeAdministrationController(fcsuc);
            uiCountry.listModeAdministrations();
        } else if (entity.equals("ActivePrinciple")) {
            FindActivePrinciplesUC fa = new FindActivePrinciplesUC(as);
            ActivePrincipleController ac = new ActivePrincipleController(fa);
            ac.ListActivePrinciples();
        } else if (entity.equals("UnitMeasurement")) {
            ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
            UnitMeasurementController uc = new UnitMeasurementController(lu);
            uc.ListUnitMeasurement();
        } else if (entity.equals("Farmacy")) {
            ListAllFarmaciesUC fcsuc = new ListAllFarmaciesUC(fs);
            FarmacyController c = new FarmacyController(fcsuc);
            c.ListFarmacies();
        } else if (entity.equals("Medicine")) {
            ListMedicinesUC lm = new ListMedicinesUC(mss);
            MedicineController mc = new MedicineController(lm);
            mc.ListMedicines();
        } else if (entity.equals("Farmacy-Medicine")) {
            ListFarmacyMedicinesUC lfm = new ListFarmacyMedicinesUC(fms);
            FarmacyMedicineController c = new FarmacyMedicineController(lfm);
            c.ListFarmacyMedicines();
        }
    }

    private void handleSearch(String entity) {
        if (entity.equals("Country")) {
            FindCountryByIdUC fcsuc = new FindCountryByIdUC(ccs);
            CountryController uiCountry = new CountryController(fcsuc);
            uiCountry.FindCountryByID();
        } else if (entity.equals("City")) {
            FindCityByIdUC fcsuc = new FindCityByIdUC(cs);
            CityController uiCity = new CityController(fcsuc);
            uiCity.FindCityByID();
        } else if (entity.equals("Region")) {
            FindRegionByIdDC fcsuc = new FindRegionByIdDC(rs);
            RegionController uiRegion = new RegionController(fcsuc);
            uiRegion.FindRegionByID();
        } else if (entity.equals("laboratory")) {
            FindLaboratoryByIdUC fli = new FindLaboratoryByIdUC(ls);
            LaboratoryController lc = new LaboratoryController(fli);
            lc.FindLaboratoryByID();
        } else if (entity.equals("Customer")) {
            FindCustomersByIdUC fcuc = new FindCustomersByIdUC(ccss);
            CustomerController c = new CustomerController(fcuc);
            c.FindCustomerByID();
        } else if (entity.equals("ModeAdministration")) {
            ModeadministrationService ms = new ModeAdministrationRepository();
            FindModeadministrationByIdUC fcsuc = new FindModeadministrationByIdUC(ms);
            ModeAdministrationController uiCountry = new ModeAdministrationController(fcsuc);
            uiCountry.findModeAdministrationById();
        } else if (entity.equals("ActivePrinciple")) {
            FindActivePrincipleByIdUC fai = new FindActivePrincipleByIdUC(as);
            ActivePrincipleController ac = new ActivePrincipleController(fai);
            ac.FindActivePrincipleByID();
        } else if (entity.equals("UnitMeasurement")) {
            FindUnitMeasurementByIdUC fu = new FindUnitMeasurementByIdUC(us);
            UnitMeasurementController uc = new UnitMeasurementController(fu);
            uc.findUnitMeasurementById();
        } else if (entity.equals("Farmacy")) {
            FindFarmaciesByIdUC fcuc = new FindFarmaciesByIdUC(fs);
            FarmacyController c = new FarmacyController(fcuc);
            c.FindFarmacyByID();
        } else if (entity.equals("Medicine")) {
            FindMedicineByIdUC fmi = new FindMedicineByIdUC(mss);
            MedicineController c = new MedicineController(fmi);
            c.FindMedicineByID();
        } else if (entity.equals("Farmacy-Medicine")) {
            FindFarmacyMedicineByIdUC ffmi = new FindFarmacyMedicineByIdUC(fms);
            FarmacyMedicineController c = new FarmacyMedicineController(ffmi);
            c.FindFarmacyMedicineByID();
        }
    }

    private void handleUpdate(String entity) {
        if (entity.equals("Country")) {
            ListAllCountriesUC fcsuc = new ListAllCountriesUC(ccs);
            FindCountryByNameUC fciduc = new FindCountryByNameUC(ccs);
            UpdateCountryUC ucuc = new UpdateCountryUC(ccs);
            CountryController uiCountry = new CountryController(ucuc, fcsuc, fciduc);
            uiCountry.UpdateCountry();
        } else if (entity.equals("City")) {
            UpdateCityUC uc = new UpdateCityUC(cs);
            FindRegionByNameUC fc = new FindRegionByNameUC(rs);
            ListRegionsUC lc = new ListRegionsUC(rs);
            FindCityByNameUC fr = new FindCityByNameUC(cs);
            FindCitiesUC lac = new FindCitiesUC(cs);
            CityController ccc = new CityController(uc,lac,fr,lc,fc);
            ccc.updateCity();
        } else if (entity.equals("Region")) {
            UpdateRegionUC uc = new UpdateRegionUC(rs);
            FindCountryByNameUC fc = new FindCountryByNameUC(ccs);
            ListAllCountriesUC lc = new ListAllCountriesUC(ccs);
            FindCountryByIdUC fcc = new FindCountryByIdUC(ccs);
            FindRegionByNameUC fr = new FindRegionByNameUC(rs);
            ListRegionsUC lac = new ListRegionsUC(rs);
            RegionController c = new RegionController(uc,fr,lac,fc,lc);
            c.updateRegion();
        } else if (entity.equals("Laboratory")) {
            UpdateLaboratoryUC uc = new UpdateLaboratoryUC(ls);
            FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
            FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
            FindCitiesUC fc = new FindCitiesUC(cs);
            FindCityByNameUC fcn = new FindCityByNameUC(cs);
            LaboratoryController lc = new LaboratoryController(uc,fl,fln,fc,fcn);
            lc.updateLaboratory();
        } else if (entity.equals("Customer")) {
            UpdateCustomerUc cc = new UpdateCustomerUc(ccss);
            ListAllCustomersUC lc = new ListAllCustomersUC(ccss);
            FindCustomerByNameUC fccn = new FindCustomerByNameUC(ccss);
            FindCitiesUC fc = new FindCitiesUC(cs);
            FindCityByNameUC fcn = new FindCityByNameUC(cs);
            FindCityByIdUC fcnd = new FindCityByIdUC(cs);
            CustomerController c = new CustomerController(cc,lc,fccn,fc,fcn,fcnd);
            c.updateCustomer();
        } else if (entity.equals("ModeAdministration")) {
            ListModeadministrationsUC fcsuc = new ListModeadministrationsUC(ms);
            FindModeadministrationByNameUC fciduc = new FindModeadministrationByNameUC(ms);
            UpdateModeadministrationUC ucuc = new UpdateModeadministrationUC(ms);
            ModeAdministrationController uiCountry = new ModeAdministrationController(ucuc, fciduc, fcsuc);
            uiCountry.updateModeAdministration();
        } else if (entity.equals("ActivePrinciple")) {
            UpdateActivePrincipleUC ua = new UpdateActivePrincipleUC(as);
            FindActivePrinciplesUC fa = new FindActivePrinciplesUC(as);
            FindActivePrincipleByNameUC fan = new FindActivePrincipleByNameUC(as);
            ActivePrincipleController ac = new ActivePrincipleController(ua,fa,fan);
            ac.UpdateActivePrinciple();
        } else if (entity.equals("UnitMeasurement")) {
            UpdateUnitMeasurementUC du = new UpdateUnitMeasurementUC(us);
            ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
            FindUnitMeasurementByNameUC fu = new FindUnitMeasurementByNameUC(us);
            UnitMeasurementController uc = new UnitMeasurementController(du,lu,fu);
            uc.updateUnitMeasurement();
        } else if (entity.equals("Farmacy")) {
            UpdateFarmacyUC uf = new UpdateFarmacyUC(fs);
            ListAllFarmaciesUC lf = new ListAllFarmaciesUC(fs);
            FindFarmacyByNameUC ffn = new FindFarmacyByNameUC(fs);
            FindCitiesUC fc = new FindCitiesUC(cs);
            FindCityByNameUC fcn = new FindCityByNameUC(cs);
            FindCityByIdUC fcnd = new FindCityByIdUC(cs);
            FarmacyController c = new FarmacyController(uf,lf,ffn,fc,fcn,fcnd);
            c.updateFarmacy();
        } else if (entity.equals("Medicine")) {
            UpdateMedicineUC um = new UpdateMedicineUC(mss);
            ListMedicinesUC lmm = new ListMedicinesUC(mss);
            ListModeadministrationsUC lm = new ListModeadministrationsUC(ms);
            ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
            FindActivePrinciplesUC fp = new FindActivePrinciplesUC(as);
            FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
            FindMedicineByNameUC fmmn = new FindMedicineByNameUC(mss);
            FindModeadministrationByNameUC fmn = new FindModeadministrationByNameUC(ms);
            FindUnitMeasurementByNameUC fumn = new FindUnitMeasurementByNameUC(us);
            FindActivePrincipleByNameUC fapn = new FindActivePrincipleByNameUC(as);
            FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
            FindModeadministrationByIdUC fmi = new FindModeadministrationByIdUC(ms);
            FindUnitMeasurementByIdUC fumi = new FindUnitMeasurementByIdUC(us);
            FindActivePrincipleByIdUC fapi = new FindActivePrincipleByIdUC(as);
            FindLaboratoryByIdUC fli = new FindLaboratoryByIdUC(ls);
            MedicineController c = new MedicineController(um,lmm,lm,lu,fp,fl,fmmn,fmn,fumn,fapn,fln,fmi,fumi,fapi,fli);
            c.updateMedicine();
        } else if (entity.equals("Farmacy-Medicine")) {
            UpdateFarmacyMedicineUC ufm = new UpdateFarmacyMedicineUC(fms);
            FindFarmacyMedicineByIdUC ffmi = new FindFarmacyMedicineByIdUC(fms);
            ListAllFarmaciesUC lf = new ListAllFarmaciesUC(fs);
            ListMedicinesUC lmm = new ListMedicinesUC(mss);
            FindFarmacyByNameUC ffn = new FindFarmacyByNameUC(fs);
            FindMedicineByNameUC fmmn = new FindMedicineByNameUC(mss);
            FarmacyMedicineController c = new FarmacyMedicineController(ufm,ffmi,lf,lmm,ffn,fmmn);
            c.updateFarmacyMedicine();
        }
    }

    private void handleDelete(String entity) {
        if (entity.equals("Country")) {
            ListAllCountriesUC fcsuc = new ListAllCountriesUC(ccs);
            FindCountryByNameUC fciduc = new FindCountryByNameUC(ccs);
            DeleteCountryUC dcuc = new DeleteCountryUC(ccs);
            CountryController uiCountry = new CountryController(dcuc, fcsuc, fciduc);
            uiCountry.DeleteCountry();
        } else if (entity.equals("City")) {
            DeleteCityUC deleteCityUC = new DeleteCityUC(cs);
            FindCitiesUC findCitiesUC = new FindCitiesUC(cs);
            FindCityByNameUC findCityByNameUC = new FindCityByNameUC(cs);
            CityController cc = new CityController(deleteCityUC, findCitiesUC, findCityByNameUC);
            cc.deleteCity();
        } else if (entity.equals("Region")) {
            DeleteRegionUC dr = new DeleteRegionUC(rs);
            FindRegionByNameUC fr = new FindRegionByNameUC(rs);
            ListRegionsUC lac = new ListRegionsUC(rs);
            RegionController rc = new RegionController(dr,fr,lac);
            rc.deleteRegion();
        } else if (entity.equals("Laboratory")) {
            DeleteLaboratoryUC dl = new DeleteLaboratoryUC(ls);
            FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
            FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
            LaboratoryController lc = new LaboratoryController(dl,fl,fln);
            lc.deleteLaboratory();
        } else if (entity.equals("Customer")) {
            DeleteCustomerUC dcuc = new DeleteCustomerUC(ccss);
            ListAllCustomersUC fcsuc = new ListAllCustomersUC(ccss);
            FindCustomerByNameUC fciduc = new FindCustomerByNameUC(ccss);
            CustomerController c = new CustomerController(dcuc, fcsuc, fciduc);
            c.deleteCustomer();
        } else if (entity.equals("ModeAdministration")) {
            ModeadministrationService ms = new ModeAdministrationRepository();
            ListModeadministrationsUC fcsuc = new ListModeadministrationsUC(ms);
            FindModeadministrationByNameUC fciduc = new FindModeadministrationByNameUC(ms);
            DeleteModeadministrationUC dcuc = new DeleteModeadministrationUC(ms);
            ModeAdministrationController uiCountry = new ModeAdministrationController(dcuc, fciduc, fcsuc);
            uiCountry.deleteModeAdministration();
        } else if (entity.equals("ActivePrinciple")) {
            DeleteActivePrincipleUC da = new DeleteActivePrincipleUC(as);
            FindActivePrinciplesUC fa = new FindActivePrinciplesUC(as);
            FindActivePrincipleByNameUC fan = new FindActivePrincipleByNameUC(as);
            ActivePrincipleController ac = new ActivePrincipleController(da,fa,fan);
            ac.DeleteActivePrinciple();
        } else if (entity.equals("UnitMeasurement")) {
            DeleteUnitMeasurementUC du = new DeleteUnitMeasurementUC(us);
            ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
            FindUnitMeasurementByNameUC fu = new FindUnitMeasurementByNameUC(us);
            UnitMeasurementController uc = new UnitMeasurementController(du,lu,fu);
            uc.deleteUnitMeasurement();
        } else if (entity.equals("Farmacy")) {
            DeleteFarmacyUC dcuc = new DeleteFarmacyUC(fs);
            ListAllFarmaciesUC fcsuc = new ListAllFarmaciesUC(fs);
            FindFarmacyByNameUC fciduc = new FindFarmacyByNameUC(fs);
            FarmacyController c = new FarmacyController(dcuc, fcsuc, fciduc);
            c.deleteFarmacy();
        } else if (entity.equals("Medicine")) {
            DeleteMedicineUC dm = new DeleteMedicineUC(mss);
            ListMedicinesUC fcsuc = new ListMedicinesUC(mss);
            FindMedicineByNameUC fcn = new FindMedicineByNameUC(mss);
            MedicineController c = new MedicineController(dm,fcsuc,fcn);
            c.deleteMedicine();
        } else if (entity.equals("Farmacy-Medicine")) {
            DeleteFarmacyMedicineUC dfm = new DeleteFarmacyMedicineUC(fms);
            ListAllFarmaciesUC lf = new ListAllFarmaciesUC(fs);
            ListMedicinesUC lm = new ListMedicinesUC(mss);
            FindFarmacyByNameUC ffn = new FindFarmacyByNameUC(fs);
            FindMedicineByNameUC fmn = new FindMedicineByNameUC(mss);
            FarmacyMedicineController c = new FarmacyMedicineController(dfm,lf,lm,ffn,fmn);
            c.deleteFarmacyMedicine();
        }
    }
}


