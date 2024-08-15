package com.example.city.aplication;

import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;

import java.util.List;

public class FindCitiesUC {
    private final CityService cityService;

    public FindCitiesUC(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute(){
        return cityService.findAllCities();
    }
}
