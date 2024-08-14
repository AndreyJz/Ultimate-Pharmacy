package com.example.country.aplication;

import com.example.country.domain.entity.Country;
import com.example.country.domain.service.CountryService;

import java.util.Optional;

public class FindCountryByIdUC {
    private final CountryService countryService;

    public FindCountryByIdUC(CountryService countryService) {this.countryService = countryService;}

    public Optional<Country> execute(String id) {return countryService.getCountryById(id); }
}
