package com.example.city.aplication;

import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;

public class CreateCityUC {
    private final CityService cityService;

    public CreateCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (City city){
        cityService.createCity(city);
    }
}
