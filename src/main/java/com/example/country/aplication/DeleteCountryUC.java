package com.example.country.aplication;

import com.example.country.domain.service.CountryService;

public class DeleteCountryUC {
    private final CountryService countryService;

    public DeleteCountryUC(CountryService countryService) {this.countryService = countryService;}

    public void execute(String id) { countryService.deleteCountry(id);}
}
