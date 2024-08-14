package com.example;

import com.example.country.aplication.*;
import com.example.country.domain.service.CountryService;
import com.example.country.infrastructure.controller.CountryController;
import com.example.country.infrastructure.repository.CountryRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CountryService cs = new CountryRepository();
        DeleteCountryUC uc = new DeleteCountryUC(cs);
        FindCountryByNameUC fc = new FindCountryByNameUC(cs);
        ListAllCountriesUC lac = new ListAllCountriesUC(cs);
        CountryController c = new CountryController(uc,lac,fc);
        c.DeleteCountry();
    }
}