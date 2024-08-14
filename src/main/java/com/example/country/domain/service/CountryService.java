package com.example.country.domain.service;

import com.example.country.domain.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    void createCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(String code);
    Optional<Country> getCountryById(String code);
    Optional<Country> getCountryByName(String name);
    List<Country> getAllCountries();
}
