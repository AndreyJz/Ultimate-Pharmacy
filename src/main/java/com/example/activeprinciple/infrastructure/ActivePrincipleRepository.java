package com.example.activeprinciple.infrastructure;

import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.activeprinciple.domain.service.ActivePrincipleService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class ActivePrincipleRepository implements ActivePrincipleService {
    private Connection connection;

    public ActivePrincipleRepository(){
        try{
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            // jdbc:mysql://localhost:3306/pharmacy
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createActivePrinciple(ActivePrinciple activePrinciple) {
        try {
            String query = "INSERT INTO activeprinciple (name) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, activePrinciple.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateActivePrinciple(ActivePrinciple activePrinciple) {
        String query = "UPDATE activeprinciple SET name = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, activePrinciple.getName());
            ps.setInt(2, activePrinciple.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Active Principle with ID " + activePrinciple.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update Active Principle with ID " + activePrinciple.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActivePrinciple deleteActivePrinciple(int id) {
        String query = "DELETE FROM activeprinciple WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<ActivePrinciple> findActivePrincipleById(int id) {
        String query = "SELECT id, name FROM activeprinciple WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        ActivePrinciple activePrinciple = new ActivePrinciple(rs.getInt("id"), rs.getString("name"));
                        return Optional.of(activePrinciple);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public List<ActivePrinciple> findAllActivePrinciple() {
        String query = "SELECT id, name FROM activeprinciple";
        List<ActivePrinciple> activePrinciples = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ActivePrinciple activeactivePrinciple = new ActivePrinciple();
                    activeactivePrinciple.setId(rs.getInt("id"));
                    activeactivePrinciple.setName(rs.getString("name"));
                    activePrinciples.add(activeactivePrinciple);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return activePrinciples;
    }

    @Override
    public Optional<ActivePrinciple> findActivePrincipleByName(String name) {
        String query = "SELECT id, name FROM activeprinciple WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ActivePrinciple activePrinciple = new ActivePrinciple(rs.getInt("id"), rs.getString("name"));
                    return Optional.of(activePrinciple);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }

}
