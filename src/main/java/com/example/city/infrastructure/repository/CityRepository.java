package com.example.city.infrastructure.repository;

import com.example.city.domain.entity.City;
import com.example.city.domain.service.CityService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCity(City city) {
        try {
            String query = "INSERT INTO city (code,name,codereg) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, city.getId());
            ps.setString(2, city.getName());
            ps.setString(3, city.getCodereg());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city) {
        String query = "UPDATE city SET name = ?, codereg = ? WHERE code = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, city.getName());
            ps.setString(2, city.getCodereg());
            ps.setString(3, city.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("City with ID " + city.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update city with ID " + city.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String id) {
        String query = "DELETE FROM city WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<City> findCityById(String id) {
        String query = "SELECT code, name, codereg FROM city WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        City city = new City(rs.getString("code"), rs.getString("name"), rs.getString("codereg"));
                        return Optional.of(city);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<City> findAllCities() {
        String query = "SELECT code, name, codereg FROM city";
        List<City> cities = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City city = new City();
                    city.setId(rs.getString("code"));
                    city.setName(rs.getString("name"));
                    city.setCodereg(rs.getString("codereg"));
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public Optional<City> findCityByName (String name) {
        String query = "SELECT code, name, codereg FROM city WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City city = new City(rs.getString("code"), rs.getString("name"), rs.getString("codereg"));
                    return Optional.of(city);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }

}
