package com.example.country.aplication;

import com.example.country.domain.entity.Country;
import com.example.country.domain.service.CountryService;

public class UpdateCountryUC {
    private final CountryService countryService;

    public UpdateCountryUC(CountryService countryService) {this.countryService = countryService;}

    public void execute(Country country) { countryService.updateCountry(country); }
}
