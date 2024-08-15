package com.example.city.domain.service;

import com.example.city.domain.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    void createCity(City city);
    void updateCity(City city);
    void deleteCity(String id);
    Optional<City> findCityById(String id);
    List<City> findAllCities();
    Optional<City> findCityByName(String name);
}
