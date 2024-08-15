import com.example.activeprinciple.domain.service.ActivePrincipleService;
import com.example.activeprinciple.infrastructure.ActivePrincipleRepository;
import com.example.laboratory.domain.service.LaboratoryService;
import com.example.laboratory.infrastructure.repository.LaboratoryRepository;
import com.example.unitmeasurement.domain.service.UnitMeasurementService;
import com.example.unitmeasurement.infrastructure.repository.UnitMeasurementRepository;//package com.example.infrastructure.controller;
//
//import com.example.city.aplication.*;
//import com.example.city.infrastructure.controller.CityController;
//import com.example.country.aplication.*;
//import com.example.country.domain.service.CountryService;
////import com.example.activeingredient.aplication.CreateActiveIngredientUC;
////import com.example.activeingredient.aplication.DeleteActiveIngredientUC;
////import com.example.activeingredient.aplication.FindActiveIngredientByIdUC;
////import com.example.activeingredient.aplication.FindActiveIngredientByNameUC;
////import com.example.activeingredient.aplication.FindActiveIngredientsUC;
////import com.example.activeingredient.aplication.UpdateActiveIngredientUC;
////import com.example.activeingredient.domain.service.ActiveIngredientService;
////import com.example.activeingredient.infrastructure.ActiveIngredientRepository;
////import com.example.activeingredient.infrastructure.ActiveIngredientUI;
////import com.example.administrationroute.aplication.CreateAdministrationRouteUC;
////import com.example.administrationroute.aplication.DeleteAdministrationRouteUC;
////import com.example.administrationroute.aplication.FindAdministrationRouteByIdUC;
////import com.example.administrationroute.aplication.FindAdministrationRouteByNameUc;
////import com.example.administrationroute.aplication.FindAdministrationRoutesUC;
////import com.example.administrationroute.aplication.UpdateAdministrationRouteUC;
////import com.example.administrationroute.domain.service.AdministrationRouteService;
////import com.example.administrationroute.infrastructure.AdministrationRouteRepository;
////import com.example.administrationroute.infrastructure.AdministrationRouteUI;
//import com.example.modeadministration.aplication.CreateModeadministrationUC;
//import com.example.modeadministration.domain.service.ModeadministrationService;
//import com.example.modeadministration.infrastructure.controller.ModeAdministrationController;
//import com.example.modeadministration.infrastructure.repository.ModeAdministrationRepository;
//import com.example.region.aplication.*;
//import com.example.region.domain.service.RegionService;
//import com.example.region.infrastructure.repository.RegionRepository;
//import com.example.region.infrastructure.controller.RegionController;
////import com.example.unitofmeasure.aplication.CreateUnitOfMeasureUC;
////import com.example.unitofmeasure.aplication.DeleteUnitOfMeasureUC;
////import com.example.unitofmeasure.aplication.FindUnitOfMeasureByIdUC;
////import com.example.unitofmeasure.aplication.FindUnitOfMeasureByNameUC;
////import com.example.unitofmeasure.aplication.FindUnitOfMeasuresUC;
////import com.example.unitofmeasure.aplication.UpdateUnitOfMeasureUC;
////import com.example.unitofmeasure.domain.service.UnitOfMeasureService;
////import com.example.unitofmeasure.infrastructure.UnitOfMeasureRepository;
////import com.example.unitofmeasure.infrastructure.UnitOfMeasureUI;
//import com.example.city.domain.service.CityService;
//import com.example.city.infrastructure.repository.CityRepository;
//import com.example.country.infrastructure.repository.CountryRepository;
//import com.example.country.infrastructure.controller.CountryController;
//import com.example.customer.aplication.CreateCustomerUC;
//import com.example.customer.aplication.DeleteCustomerUC;
//import com.example.customer.aplication.FindCustomerByNameUC;
//import com.example.customer.domain.service.CustomerService;
//import com.example.customer.infrastructure.repository.CustomerRepository;
////import com.example.customer.infrastructure.controller.CustomerController;
////import com.example.idtype.aplication.DeleteIdTypeUC;
////import com.example.idtype.aplication.FindIdTypeByIdUC;
////import com.example.idtype.aplication.FindIdTypeByNameUc;
////import com.example.idtype.aplication.FindIdTypesUC;
////import com.example.idtype.aplication.SaveIdTypeUC;
////import com.example.idtype.aplication.UpdateIdTypeUC;
////import com.example.idtype.domain.service.IdTypeService;
////import com.example.idtype.infrastructure.IdTypeRepository;
////import com.example.idtype.infrastructure.IdTypeUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.HashMap;
//import java.util.Map;
//
//public class PharmacyController extends JFrame implements ActionListener {
//    private static final String CREATE = "Create";
//    private static final String LIST = "List";
//    private static final String SEARCH = "Search";
//    private static final String UPDATE = "Update";
//    private static final String DELETE = "Delete";
//    private static final String EXIT = "Exit";
//
//    private Map<String, JPanel> panels;
//    private Map<String, JButton> buttons;
//
//    private JPanel mainMenuPanel;
//    private JPanel contentPanel;
//
//    public PharmacyController() {
//        initializeController();
//    }
//
//    private void initializeUI() {
//        setTitle("Pharmacy Menu");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        panels = new HashMap<>();
//        buttons = new HashMap<>();
//
//        setLayout(new BorderLayout());
//
//        mainMenuPanel = new JPanel(new GridLayout(0,2,25,50));
//        mainMenuPanel.setBounds(50,25,500,300);
//        initializeMainPanel();
//        add(mainMenuPanel);
//
//        contentPanel = new JPanel(new CardLayout());
//        initializeSubPanels();
//        add(contentPanel, BorderLayout.CENTER);
//        contentPanel.setVisible(false);
//
//        setVisible(true);
//    }
//
//    private void initializeMainPanel() {
//        String[] mainOptions = {"Country", "City", "Region", "IdType", "Customer", "AdministrationRoute", "ActiveIngredient", "UnitOfMeasure"};
//        for (String option : mainOptions) {
//            addButton(mainMenuPanel, option, this);
//        }
//    }
//
//    private void initializeSubPanels() {
//        String[] entities = {"Country", "City", "Region", "IdType", "Customer", "AdministrationRoute", "ActiveIngredient", "UnitOfMeasure"};
//        for (String entity : entities) {
//            JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
//            addEntityButtons(panel, entity);
//            panels.put(entity, panel);
//            contentPanel.add(panel, entity);
//        }
//    }
//
//    private void addEntityButtons(JPanel panel, String entity) {
//        addButton(panel, CREATE + " " + entity, this);
//        addButton(panel, LIST + " " + entity, this);
//        addButton(panel, SEARCH + " " + entity, this);
//        addButton(panel, UPDATE + " " + entity, this);
//        addButton(panel, DELETE + " " + entity, this);
//        addButton(panel, EXIT, this);
//    }
//
//    private void addButton(JPanel panel, String text, ActionListener listener) {
//        JButton button = new JButton(text);
//        button.setBackground(Color.LIGHT_GRAY);
//
//        ImageIcon icon = new ImageIcon();
//
//        if (text.trim().contains("Create")) {
//            icon = new ImageIcon(new ImageIcon("src/images/create-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        } else if (text.startsWith(LIST)) {
//            icon = new ImageIcon(new ImageIcon("src/main/resources/images/create-svgrepo-com (2).svg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        } else if (text.startsWith(SEARCH)) {
//            icon = new ImageIcon(new ImageIcon("src/main/resources/images/find-on-map-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        } else if (text.startsWith(UPDATE)) {
//            icon = new ImageIcon(new ImageIcon("src/main/resources/images/create-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        } else if (text.startsWith(DELETE)) {
//            icon = new ImageIcon(new ImageIcon("src/main/resources/images/icons8-basura.svg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        } else if (text.startsWith(EXIT)) {
//            icon = new ImageIcon(new ImageIcon("src/main/resources/images/house-shape-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        }
//
////        ImageIcon icon = new ImageIcon(new ImageIcon("src/main/resources/images/45069.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
////        button.setIcon(icon);
////        icon = new ImageIcon(new ImageIcon("src/main/resources/images/create-svgrepo-com.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//
//        button.setIcon(icon);
//        button.addActionListener(listener);
//        panel.add(button);
//        buttons.put(text, button);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String command = e.getActionCommand();
//        if (panels.containsKey(command)) {
//            showPanel(command);
//        } else if (command.startsWith(CREATE)) {
//            handleCreate(command.split(" ")[1]);
//        } else if (command.startsWith(LIST)) {
//            handleList(command.split(" ")[1]);
//        } else if (command.startsWith(SEARCH)) {
//            handleSearch(command.split(" ")[1]);
//        } else if (command.startsWith(UPDATE)) {
//            handleUpdate(command.split(" ")[1]);
//        } else if (command.startsWith(DELETE)) {
//            handleDelete(command.split(" ")[1]);
//        } else if (command.equals(EXIT)) {
//            showPanel("MAIN");  // Volver al panel principal en lugar de salir
//            contentPanel.setVisible(false);
//            mainMenuPanel.setVisible(true);
//        }
//    }
//
//    private void showPanel(String panelName) {
//        contentPanel.setVisible(true);
//        mainMenuPanel.setVisible(false);
//        CardLayout cl = (CardLayout) contentPanel.getLayout();
//        cl.show(contentPanel, panelName);
//        System.out.println("Showing panel: " + panelName);  // Depuración
//    }
//
//    RegionService rs = new RegionRepository();
//    CityService cs = new CityRepository();
//    CountryService ccs = new CountryRepository();
//    UnitMeasurementService us = new UnitMeasurementRepository();
//    ActivePrincipleService as = new ActivePrincipleRepository();
//    LaboratoryService ls = new LaboratoryRepository();
//    ModeadministrationService ms = new ModeAdministrationRepository();
//    CustomerService ccss = new CustomerRepository();
//
//
//    private void handleCreate(String entity) {
//        if (entity.equals("Country")) {
//            CreateCountryUC cc = new CreateCountryUC(ccs);
//            CountryController ccc = new CountryController(cc);
//            ccc.CreateCountry();
//        } else if (entity.equals("City")) {
//            CreateCityUC cc = new CreateCityUC(cs);
//            FindRegionByNameUC frn = new FindRegionByNameUC(rs);
//            ListRegionsUC lr = new ListRegionsUC(rs);
//            CityController ccc = new CityController(cc,lr,frn);
//            ccc.createCity();
//        } else if (entity.equals("Region")) {
//            CreateRegionUC uc = new CreateRegionUC(rs);
//            FindCountryByNameUC fc = new FindCountryByNameUC(ccs);
//            ListAllCountriesUC lc = new ListAllCountriesUC(ccs);
//            RegionController c = new RegionController(uc,fc,lc);
//            c.createRegion();
//        } else if (entity.equals("Laboratory")) {
//            CreateLaboratoryUC cl = new CreateLaboratoryUC(ls);
////        FindCitiesUC fc = new FindCitiesUC(ccs);
////        FindCityByNameUC fcn = new FindCityByNameUC(ccs);
////        LaboratoryController lc = new LaboratoryController(cl, fc, fcn);
////        lc.createLaboratory();
//        } else if (entity.equals("Customer")) {
//            CreateCustomerUC cc = new CreateCustomerUC(ccss);
//        FindCitiesUC fc = new FindCitiesUC(ccs);
//        FindCityByNameUC fcn = new FindCityByNameUC(ccs);
//        CustomerController c = new CustomerController(cc,fc,fcn);
//        c.createCustomer();
//        } else if (entity.equals("AdministrationRoute")) {
//            CreateModeadministrationUC cm = new CreateModeadministrationUC(ms);
//            ModeAdministrationController mc = new ModeAdministrationController(cm);
//            mc.createModeAdministration();
//        } else if (entity.equals("ActivePrinciple")) {
//            CreateActivePrincipleUC ca = new CreateActivePrincipleUC(as);
//        ActivePrincipleController ac = new ActivePrincipleController(ca);
//        ac.CreateActivePrinciple();
//        } else if (entity.equals("UnitOfMeasure")) {
//            UnitMeasurementService us = new UnitMeasurementRepository();
//        CreateUnitMeasurementUC cu = new CreateUnitMeasurementUC(us);
//        UnitMeasurementController uc = new UnitMeasurementController(cu);
//        uc.createUnitMeasurement();
//        }
//    }
//
//    private void handleList(String entity) {
//        if (entity.equals("Country")) {
//            ListAllCountriesUC fcsuc = new ListAllCountriesUC(ccs);
//            CountryController uiCountry = new CountryController(fcsuc);
//            uiCountry.ListCountries();
//        } else if (entity.equals("City")) {
//            FindCitiesUC fcsuc = new FindCitiesUC(cs);
//            CityController uiCity = new CityController(fcsuc);
//            uiCity.ListCities();
//        } else if (entity.equals("Region")) {
//            ListRegionsUC fnsuc = new ListRegionsUC(rs);
//            RegionController uiRegion = new RegionController(fnsuc);
//            uiRegion.ListRegions();
//        } else if (entity.equals("Laboratory")) {
//            FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
////        LaboratoryController lc = new LaboratoryController(fl);
////        lc.ListLaboratories();
//        } else if (entity.equals("Customer")) {
//            CustomerService cs = new CustomerRepository();
//            FindCustomersUC fcsuc = new FindCustomersUC(cs);
//            CustomerUI uiCustomer = new CustomerUI(fcsuc);
//            uiCustomer.ListCustomers();
//        } else if (entity.equals("AdministrationRoute")) {
//            ModeadministrationService ms = new ModeAdministrationRepository();
//            ListModeadministrationsUC fcsuc = new ListModeadministrationsUC(ms);
//            ModeAdministrationController uiCountry = new ModeAdministrationController(fcsuc);
//            uiCountry.listModeAdministrations();
//        } else if (entity.equals("ActivePrinciple")) {
//            FindActivePrinciplesUC fa = new FindActivePrinciplesUC(as);
//        ActivePrincipleController ac = new ActivePrincipleController(fa);
//        ac.ListActiveIngredients();
//        } else if (entity.equals("UnitOfMeasure")) {
//            ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
//        UnitMeasurementController uc = new UnitMeasurementController(lu);
//        uc.ListUnitMeasurement();
//        }
//    }
//
//    private void handleSearch(String entity) {
//        if (entity.equals("Country")) {
//            FindCountryByIdUC fcsuc = new FindCountryByIdUC(ccs);
//            CountryController uiCountry = new CountryController(fcsuc);
//            uiCountry.FindCountryByID();
//        } else if (entity.equals("City")) {
//            FindCityByIdUC fcsuc = new FindCityByIdUC(cs);
//            CityController uiCity = new CityController(fcsuc);
//            uiCity.FindCityByID();
//        } else if (entity.equals("Region")) {
//            FindRegionByIdDC fcsuc = new FindRegionByIdDC(rs);
//            RegionController uiRegion = new RegionController(fcsuc);
//            uiRegion.FindRegionByID();
//        } else if (entity.equals("laboratory")) {
//            FindLaboratoryByIdUC fli = new FindLaboratoryByIdUC(ls);
//        LaboratoryController lc = new LaboratoryController(fli);
//        lc.FindLaboratoryByID();
//        } else if (entity.equals("Customer")) {
//            CustomerService cs = new CustomerRepository();
//            FindCustomerByIdUC fcuc = new FindCustomerByIdUC(cs);
//            CustomerUI uiCustomer = new CustomerUI(fcuc);
//            uiCustomer.FindCustomerById();
//        } else if (entity.equals("AdministrationRoute")) {
//            ModeadministrationService ms = new ModeAdministrationRepository();
//            FindModeadministrationByIdUC fcsuc = new FindModeadministrationByIdUC(ms);
//            ModeAdministrationController uiCountry = new ModeAdministrationController(fcsuc);
//            uiCountry.findModeAdministrationById();
//        } else if (entity.equals("ActivePrinciple")) {
//            FindActivePrincipleByIdUC fai = new FindActivePrincipleByIdUC(as);
//        ActivePrincipleController ac = new ActivePrincipleController(fai);
//        ac.FindActivePrincipleByID();
//        } else if (entity.equals("UnitOfMeasure")) {
//            FindUnitMeasurementByIdUC fu = new FindUnitMeasurementByIdUC(us);
//        UnitMeasurementController uc = new UnitMeasurementController(fu);
//        uc.findUnitMeasurementById();
//        }
//    }
//
//    private void handleUpdate(String entity) {
//        if (entity.equals("Country")) {
//            ListAllCountriesUC fcsuc = new ListAllCountriesUC(ccs);
//            FindCountryByNameUC fciduc = new FindCountryByNameUC(ccs);
//            UpdateCountryUC ucuc = new UpdateCountryUC(ccs);
//            CountryController uiCountry = new CountryController(ucuc, fcsuc, fciduc);
//            uiCountry.UpdateCountry();
//        } else if (entity.equals("City")) {
//            UpdateCityUC uc = new UpdateCityUC(cs);
//            FindRegionByNameUC fc = new FindRegionByNameUC(rs);
//            ListRegionsUC lc = new ListRegionsUC(rs);
//            FindCityByNameUC fr = new FindCityByNameUC(cs);
//            FindCitiesUC lac = new FindCitiesUC(cs);
//            CityController ccc = new CityController(uc,lac,fr,lc,fc);
//            ccc.updateCity();
//        } else if (entity.equals("Region")) {
//            UpdateRegionUC uc = new UpdateRegionUC(rs);
//            FindCountryByNameUC fc = new FindCountryByNameUC(ccs);
//            ListAllCountriesUC lc = new ListAllCountriesUC(ccs);
//            FindCountryByIdUC fcc = new FindCountryByIdUC(ccs);
//            FindRegionByNameUC fr = new FindRegionByNameUC(rs);
//            ListRegionsUC lac = new ListRegionsUC(rs);
//            RegionController c = new RegionController(uc,fr,lac,fc,lc);
//            c.updateRegion();
//        } else if (entity.equals("Laboratory")) {
//            UpdateLaboratoryUC uc = new UpdateLaboratoryUC(ls);
////        FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
////        FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
////        FindCitiesUC fc = new FindCitiesUC(ccs);
////        FindCityByNameUC fcn = new FindCityByNameUC(ccs);
////        LaboratoryController lc = new LaboratoryController(uc,fl,fln,fc,fcn);
////        lc.updateLaboratory();
//        } else if (entity.equals("Customer")) {
//            RegionService ns = new RegionRepository();
//            IdTypeService its = new IdTypeRepository();
//            CustomerService cs = new CustomerRepository();
//            FindRegionsUC fnuc = new FindRegionsUC(ns);
//            FindIdTypesUC fitsuc = new FindIdTypesUC(its);
//            FindRegionByIdUC fniduc = new FindRegionByIdUC(ns);
//            FindIdTypeByIdUC fitiduc = new FindIdTypeByIdUC(its);
//            FindRegionByNameUC fnnuc = new FindRegionByNameUC(ns);
//            FindIdTypeByNameUc fitnuc = new FindIdTypeByNameUc(its);
//            FindCustomersUC fcsuc = new FindCustomersUC(cs);
//            FindCustomerByNameUC fciduc = new FindCustomerByNameUC(cs);
//            UpdateCustomerUC ucuc = new UpdateCustomerUC(cs);
//            CustomerUI uiCustomer = new CustomerUI(ucuc, fcsuc, fciduc, fnuc, fnnuc, fitsuc, fitnuc, fitiduc, fniduc);
//            uiCustomer.UpdateCustomer();
//        } else if (entity.equals("AdministrationRoute")) {
//            ListModeadministrationsUC fcsuc = new ListModeadministrationsUC(ms);
//        FindModeadministrationByNameUC fciduc = new FindModeadministrationByNameUC(ms);
//        UpdateModeadministrationUC ucuc = new UpdateModeadministrationUC(ms);
//        ModeAdministrationController uiCountry = new ModeAdministrationController(ucuc, fciduc, fcsuc);
//        uiCountry.updateModeAdministration();
//        } else if (entity.equals("ActivePrinciple")) {
//            UpdateActivePrincipleUC ua = new UpdateActivePrincipleUC(as);
//        FindActivePrinciplesUC fa = new FindActivePrinciplesUC(as);
//        FindActivePrincipleByNameUC fan = new FindActivePrincipleByNameUC(as);
//        ActivePrincipleController ac = new ActivePrincipleController(ua,fa,fan);
//        ac.UpdateActivePrinciple();
//        } else if (entity.equals("UnitOfMeasure")) {
//            UpdateUnitMeasurementUC du = new UpdateUnitMeasurementUC(us);
//        ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
//        FindUnitMeasurementByNameUC fu = new FindUnitMeasurementByNameUC(us);
//        UnitMeasurementController uc = new UnitMeasurementController(du,lu,fu);
//        uc.updateUnitMeasurement();
//        }
//    }
//
//    private void handleDelete(String entity) {
//        if (entity.equals("Country")) {
//            ListAllCountriesUC fcsuc = new ListAllCountriesUC(ccs);
//            FindCountryByNameUC fciduc = new FindCountryByNameUC(ccs);
//            DeleteCountryUC dcuc = new DeleteCountryUC(ccs);
//            CountryController uiCountry = new CountryController(dcuc, fcsuc, fciduc);
//            uiCountry.DeleteCountry();
//        } else if (entity.equals("City")) {
//            DeleteCityUC deleteCityUC = new DeleteCityUC(cs);
//            FindCitiesUC findCitiesUC = new FindCitiesUC(cs);
//            FindCityByNameUC findCityByNameUC = new FindCityByNameUC(cs);
//            CityController cc = new CityController(deleteCityUC, findCitiesUC, findCityByNameUC);
//            cc.deleteCity();
//        } else if (entity.equals("Region")) {
//            DeleteRegionUC dr = new DeleteRegionUC(rs);
//            FindRegionByNameUC fr = new FindRegionByNameUC(rs);
//            ListRegionsUC lac = new ListRegionsUC(rs);
//            RegionController rc = new RegionController(dr,fr,lac);
//            rc.deleteRegion();
//        } else if (entity.equals("IdType")) {
//            DeleteLaboratoryUC dl = new DeleteLaboratoryUC(ls);
////        FindLaboratoriesUC fl = new FindLaboratoriesUC(ls);
////        FindLaboratoryByNameUC fln = new FindLaboratoryByNameUC(ls);
////        LaboratoryController lc = new LaboratoryController(dl,fl,fln);
////        lc.deleteLaboratory();
//        } else if (entity.equals("Customer")) {
//            CustomerService cs = new CustomerRepository();
//            FindCustomersUC fcsuc = new FindCustomersUC(cs);
//            FindCustomerByNameUC fciduc = new FindCustomerByNameUC(cs);
//            DeleteCustomerUC dcuc = new DeleteCustomerUC(cs);
//            CustomerUI uiCustomer = new CustomerUI(dcuc, fcsuc, fciduc);
//            uiCustomer.DeleteCustomer();
//        } else if (entity.equals("AdministrationRoute")) {
//            ModeadministrationService ms = new ModeAdministrationRepository();
//        ListModeadministrationsUC fcsuc = new ListModeadministrationsUC(ms);
//        FindModeadministrationByNameUC fciduc = new FindModeadministrationByNameUC(ms);
//        DeleteModeadministrationUC dcuc = new DeleteModeadministrationUC(ms);
//        ModeAdministrationController uiCountry = new ModeAdministrationController(dcuc, fciduc, fcsuc);
//        uiCountry.deleteModeAdministration();
//        } else if (entity.equals("ActivePrinciple")) {
//            DeleteActivePrincipleUC da = new DeleteActivePrincipleUC(as);
//        FindActivePrinciplesUC fa = new FindActivePrinciplesUC(as);
//        FindActivePrincipleByNameUC fan = new FindActivePrincipleByNameUC(as);
//        ActivePrincipleController ac = new ActivePrincipleController(da,fa,fan);
//        ac.DeleteActivePrinciple();
//        } else if (entity.equals("UnitOfMeasure")) {
//            DeleteUnitMeasurementUC du = new DeleteUnitMeasurementUC(us);
//        ListUnitMeasurementsUC lu = new ListUnitMeasurementsUC(us);
//        FindUnitMeasurementByNameUC fu = new FindUnitMeasurementByNameUC(us);
//        UnitMeasurementController uc = new UnitMeasurementController(du,lu,fu);
//        uc.deleteUnitMeasurement();
//        }
//    }
//}
//
//
