package com.example.city.aplication;

import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;

import java.util.Optional;

public class FindCityByNameUC {
    private final CityService cityService;

    public FindCityByNameUC(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(String name) {
        return cityService.findCityByName(name);
    }
}
