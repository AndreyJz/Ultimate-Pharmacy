package com.example.city.aplication;

import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;

import java.util.Optional;

public class FindCityByIdUC {
    private final CityService cityService;

    public FindCityByIdUC(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(String id){
        return cityService.findCityById(id);
    }
}
