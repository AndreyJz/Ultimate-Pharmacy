package com.example.modeadministration.infrastructure.repository;

import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.modeadministration.domain.service.ModeadministrationService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class ModeAdministrationRepository implements ModeadministrationService {
    private Connection connection;

    public ModeAdministrationRepository() {
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
    public void createModeAdministration(Modeadministration modeAdministration) {
        String query = "INSERT INTO modeadministration (description) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, modeAdministration.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateModeAdministration(Modeadministration modeAdministration) {
        String query = "UPDATE modeadministration SET description = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, modeAdministration.getDescription());
            ps.setInt(2, modeAdministration.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteModeAdministration(int id) {
        String query = "DELETE FROM modeadministration WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Modeadministration> findModeAdministrationById(int id) {
        String query = "SELECT id, description FROM modeadministration WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Modeadministration modeAdministration = new Modeadministration(rs.getInt("id"), rs.getString("description"));
                    return Optional.of(modeAdministration);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Modeadministration> findModeAdministrationByDescripcion(String name) {
        String query = "SELECT id, description FROM modeadministration WHERE description = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Modeadministration modeAdministration = new Modeadministration(rs.getInt("id"), rs.getString("description"));
                    return Optional.of(modeAdministration);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Modeadministration> findAllModeAdministrations() {
        String query = "SELECT id, description FROM modeadministration";
        List<Modeadministration> modeAdministrations = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Modeadministration modeAdministration = new Modeadministration(rs.getInt("id"), rs.getString("description"));
                modeAdministrations.add(modeAdministration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modeAdministrations;
    }
}
