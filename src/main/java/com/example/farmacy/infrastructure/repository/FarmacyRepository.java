package com.example.farmacy.infrastructure.repository;

import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacy.domain.service.FarmacyService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class FarmacyRepository implements FarmacyService {
    private Connection connection;
    
    public FarmacyRepository(){
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
    public void createFarmacy(Farmacy farmacy) {
        String query = "INSERT INTO farmacy (name,address,lon,lat,codecity,logo) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, farmacy.getName());
            System.out.println(farmacy.getAdress());
            ps.setString(2, farmacy.getAdress());
            ps.setFloat(3, farmacy.getLon());
            ps.setFloat(4, farmacy.getLat());
            ps.setString(5, farmacy.getCodeCity());
            ps.setString(6, farmacy.getLogo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFarmacy(Farmacy farmacy) {
        String query = "UPDATE farmacy SET name = ?,address = ?,lon = ?,lat = ?,codecity = ?,logo = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, farmacy.getName());
            ps.setString(2, farmacy.getAdress());
            ps.setFloat(3, farmacy.getLon());
            ps.setFloat(4, farmacy.getLat());
            ps.setString(5, farmacy.getCodeCity());
            ps.setString(6, farmacy.getLogo());
            ps.setInt(7, farmacy.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.addSuppressed(e);
        }
    }

    @Override
    public void deleteFarmacy(String id) {
        String query = "DELETE FROM farmacy WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Farmacy> getFarmacyById(String id) {
        String query = "SELECT id,name,address,lon,lat,codecity,logo FROM farmacy WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farmacy customer = new Farmacy();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAdress(rs.getString("address"));
                customer.setLon(rs.getFloat("lon"));
                customer.setLat(rs.getFloat("lat"));
                customer.setCodeCity(rs.getString("codecity"));
                customer.setLogo(rs.getString("logo"));

                return Optional.of(customer);

            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Farmacy> getAllFarmacies() {
        String query = "SELECT id,name,address,lon,lat,codecity,logo FROM farmacy";
        List<Farmacy> customers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Farmacy customer = new Farmacy();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAdress(rs.getString("address"));
                customer.setLon(rs.getFloat("lon"));
                customer.setLat(rs.getFloat("lat"));
                customer.setCodeCity(rs.getString("codecity"));
                customer.setLogo(rs.getString("logo"));
                System.out.println(rs.getString("logo"));

                customers.add(customer);
            }

        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return customers;
    }

    @Override
    public Optional<Farmacy> getFarmacyByName(String name) {
        String query = "SELECT id,name,address,lon,lat,codecity,logo FROM farmacy WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Farmacy customer = new Farmacy();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAdress(rs.getString("address"));
                customer.setLon(rs.getFloat("lon"));
                customer.setLat(rs.getFloat("lat"));
                customer.setCodeCity(rs.getString("codecity"));
                customer.setLogo(rs.getString("logo"));

                return Optional.of(customer);
            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }
    
}
