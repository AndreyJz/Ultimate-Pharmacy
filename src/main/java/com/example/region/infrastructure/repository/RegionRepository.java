package com.example.region.infrastructure.repository;

import com.example.city.domain.entity.City;
import com.example.region.domain.entity.Region;
import com.example.region.domain.service.RegionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class RegionRepository implements RegionService {
    private Connection connection;

    public RegionRepository() {
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
    public void createRegion(Region region) {
        try {
            String query = "INSERT INTO region (code,name,codecountry) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, region.getId());
            ps.setString(2, region.getName());
            ps.setString(3, region.getCodecountry());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRegion(Region region) {
        String query = "UPDATE region SET name = ?,codecountry = ? WHERE code = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, region.getName());
            ps.setString(2, region.getCodecountry());
            ps.setString(3, region.getId());

            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Region with ID " + region.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update region with ID " + region.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegion(String id) {
        String query = "DELETE FROM region WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Region> findRegionById(String id) {
        String query = "SELECT code, name, codecountry FROM region WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Region region = new Region(rs.getString("code"), rs.getString("name"), rs.getString("codecountry"));
                    return Optional.of(region);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Region> findAllCRegions() {
        String query = "SELECT code, name, codecountry FROM region";
        List<Region> regions = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Region region = new Region();
                    region.setId(rs.getString("code"));
                    region.setName(rs.getString("name"));
                    region.setCodecountry(rs.getString("codecountry"));
                    regions.add(region);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public Optional<Region> findRegionByName(String name) {
        String query = "SELECT code, name, codecountry FROM region WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Region region = new Region(rs.getString("code"), rs.getString("name"), rs.getString("codecountry"));
                    return Optional.of(region);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }
}
