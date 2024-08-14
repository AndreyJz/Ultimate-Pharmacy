package com.example.country.aplication;

import com.example.country.domain.entity.Country;
import com.example.country.domain.service.CountryService;

import java.util.List;

public class ListAllCountriesUC {
    private final CountryService countryService;

    public ListAllCountriesUC(CountryService countryService) {this.countryService = countryService;}

    public List<Country> execute() {return countryService.getAllCountries(); }
}
