package com.example.city.aplication;

import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;

public class UpdateCityUC {
    private final CityService cityService;

    public UpdateCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(City city) {this.cityService.updateCity(city);}
}
