package com.example.laboratory.infrastructure.repository;

import com.example.laboratory.domain.entity.Laboratory;
import com.example.laboratory.domain.service.LaboratoryService;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class LaboratoryRepository implements LaboratoryService {
    private Connection connection;

    public LaboratoryRepository() {
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
    public void createLaboratory(Laboratory laboratory) {
        String query = "INSERT INTO labatory (name, codecityreg) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, laboratory.getName());
            ps.setString(2, laboratory.getCodeCityReg());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    laboratory.setId(generatedKeys.getInt(1));
                }
            }
            JOptionPane.showMessageDialog(null, "Laboratory has been added!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateLaboratory(Laboratory laboratory) {
        String query = "UPDATE labatory SET name = ?, codecityreg = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, laboratory.getName());
            ps.setString(2, laboratory.getCodeCityReg());
            ps.setInt(3, laboratory.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Laboratory has been updated!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteLaboratory(int id) {
        String query = "DELETE FROM labatory WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Laboratory> findLaboratoryById(int id) {
        String query = "SELECT id, name, codecityreg FROM labatory WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Laboratory laboratory = new Laboratory(rs.getInt("id"), rs.getString("name"), rs.getString("codecityreg"));
                        return Optional.of(laboratory);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Laboratory> findAllLaboratories() {
        String query = "SELECT id, name, codecityreg FROM labatory";
        List<Laboratory> cities = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Laboratory laboratory = new Laboratory();
                    laboratory.setId(rs.getInt("id"));
                    laboratory.setName(rs.getString("name"));
                    laboratory.setCodeCityReg(rs.getString("codecityreg"));
                    cities.add(laboratory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public Optional<Laboratory> findLaboratoryByName (String name) {
        String query = "SELECT id, name, codecityreg FROM labatory WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Laboratory laboratory = new Laboratory(rs.getInt("id"), rs.getString("name"), rs.getString("codecityreg"));
                    return Optional.of(laboratory);
                }
            }
        } catch (SQLException e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }

}
