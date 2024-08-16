package com.example.country.infrastructure.repository;

import com.example.country.domain.entity.Country;
import com.example.country.domain.service.CountryService;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CountryRepository implements CountryService {
    private Connection connection;

    public CountryRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            connection = DriverManager.getConnection(url,user, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCountry(Country country) {
        String query = "INSERT INTO country(code, name) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getCode());
            ps.setString(2, country.getName());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Country has been created!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateCountry(Country country) {
        String query = "UPDATE country SET name = ? WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getName());
            ps.setString(2, country.getCode());

            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null,"Country with ID " + country.getCode() + " updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null,"Failed to update country with ID " + country.getCode() + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteCountry(String code) {
        String query = "DELETE FROM country WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, code);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Country> getCountryById(String code) {
        String query = "SELECT * FROM country WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Country country = new Country();
                    country.setCode(rs.getString("code"));
                    country.setName(rs.getString("name"));
                    return Optional.of(country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> getCountryByName(String name) {
        String query = "SELECT * FROM country WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Country country = new Country();
                    country.setCode(rs.getString("code"));
                    country.setName(rs.getString("name"));
                    return Optional.of(country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Country> getAllCountries() {
        String query = "SELECT * FROM country";
        List<Country> countries = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Country country = new Country();
                    country.setCode(rs.getString("code"));
                    country.setName(rs.getString("name"));
                    countries.add(country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
