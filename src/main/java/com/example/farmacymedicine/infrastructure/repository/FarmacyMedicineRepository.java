package com.example.farmacymedicine.infrastructure.repository;

import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.farmacymedicine.domain.service.FarmacyMedicineService;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class FarmacyMedicineRepository implements FarmacyMedicineService {
    private Connection connection;

    public FarmacyMedicineRepository() {
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
    public void createFarmacyMedicine(FarmacyMedicine farmacyMedicine) {
        String query = "INSERT INTO farmacyMedicine (id_farmacy, id_medicinefartm, price) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, farmacyMedicine.getIdFarmacy());
            ps.setInt(2, farmacyMedicine.getIdMedicineFartm());
            ps.setFloat(3, farmacyMedicine.getPrice());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Farmacy-Medicine has been added!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateFarmacyMedicine(FarmacyMedicine farmacyMedicine) {
        String query = "UPDATE farmacyMedicine SET price = ? WHERE id_farmacy = ? AND id_medicinefartm = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setFloat(1, farmacyMedicine.getPrice());
            ps.setInt(2, farmacyMedicine.getIdFarmacy());
            ps.setInt(3, farmacyMedicine.getIdMedicineFartm());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Farmacy-Medicine has been updated!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteFarmacyMedicine(int idFarmacy, int idMedicineFartm) {
        String query = "DELETE FROM farmacyMedicine WHERE id_farmacy = ? AND id_medicinefartm = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idFarmacy);
            ps.setInt(2, idMedicineFartm);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<FarmacyMedicine> findById(int idFarmacy, int idMedicineFartm) {
        String query = "SELECT id_farmacy, id_medicinefartm, price FROM farmacyMedicine WHERE id_farmacy = ? AND id_medicinefartm = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idFarmacy);
            ps.setInt(2, idMedicineFartm);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new FarmacyMedicine(rs.getInt("id_farmacy"), rs.getInt("id_medicinefartm"),
                            rs.getFloat("price")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<FarmacyMedicine> findAllFarmacyMedicine() {
        String query = "SELECT id_farmacy, id_medicinefartm, price FROM farmacyMedicine";
        List<FarmacyMedicine> farmacyMedicines = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                farmacyMedicines.add(new FarmacyMedicine(rs.getInt("id_farmacy"), rs.getInt("id_medicinefartm"),
                        rs.getFloat("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return farmacyMedicines;
    }
}
