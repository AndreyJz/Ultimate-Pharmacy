package com.example.city.aplication;

import com.example.city.domain.service.CityService;

public class DeleteCityUC {
    private final CityService cityService;

    public DeleteCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(String id) { this.cityService.deleteCity(id); }
}
