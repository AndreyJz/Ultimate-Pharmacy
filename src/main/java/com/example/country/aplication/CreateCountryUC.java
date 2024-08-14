package com.example.country.aplication;

import com.example.country.domain.entity.Country;
import com.example.country.domain.service.CountryService;

public class CreateCountryUC {
    private final CountryService countryService;

    public CreateCountryUC(CountryService countryService) {this.countryService = countryService;}

    public void execute(Country country) { countryService.createCountry(country);}
}
