package com.example.country.aplication;

import com.example.country.domain.entity.Country;
import com.example.country.domain.service.CountryService;

import java.util.Optional;

public class FindCountryByNameUC {
    private final CountryService countryService;

    public FindCountryByNameUC(CountryService countryService) {this.countryService = countryService;}

    public Optional<Country> execute(String name) {return countryService.getCountryByName(name); }
}
