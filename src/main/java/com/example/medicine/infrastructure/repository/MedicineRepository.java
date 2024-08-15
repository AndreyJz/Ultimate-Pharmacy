package com.example.medicine.infrastructure.repository;

import com.example.medicine.domain.entity.Medicine;
import com.example.medicine.domain.service.MedicineService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class MedicineRepository implements MedicineService {
    private Connection connection;

    public MedicineRepository() {
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
    public void createMedicine(Medicine medicine) {
        String query = "INSERT INTO medicine (proceedings, name, healthregister, description, descriptionShort, codemodeadmin, codepa, codeum, codelab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, medicine.getProceedings());
            ps.setString(2, medicine.getName());
            ps.setString(3, medicine.getHealthRegister());
            ps.setString(4, medicine.getDescription());
            ps.setString(5, medicine.getDescriptionShort());
            ps.setInt(6, medicine.getCodeModeAdmin());
            ps.setInt(7, medicine.getCodePa());
            ps.setInt(8, medicine.getCodeUm());
            ps.setInt(9, medicine.getCodeLab());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        String query = "UPDATE medicine SET proceedings = ?, name = ?, healthregister = ?, description = ?, descriptionShort = ?, codemodeadmin = ?, codepa = ?, codeum = ?, codelab = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, medicine.getProceedings());
            ps.setString(2, medicine.getName());
            ps.setString(3, medicine.getHealthRegister());
            ps.setString(4, medicine.getDescription());
            ps.setString(5, medicine.getDescriptionShort());
            ps.setInt(6, medicine.getCodeModeAdmin());
            ps.setInt(7, medicine.getCodePa());
            ps.setInt(8, medicine.getCodeUm());
            ps.setInt(9, medicine.getCodeLab());
            ps.setInt(10, medicine.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        String query = "DELETE FROM medicine WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Medicine> findMedicineById(int id) {
        String query = "SELECT id, proceedings, name, healthregister, description, descriptionShort, codemodeadmin, codepa, codeum, codelab FROM medicine WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Medicine(rs.getInt("id"), rs.getString("proceedings"), rs.getString("name"),
                            rs.getString("healthregister"), rs.getString("description"), rs.getString("descriptionShort"),
                            rs.getInt("codemodeadmin"), rs.getInt("codepa"), rs.getInt("codeum"), rs.getInt("codelab")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Medicine> findMedicineByName(String name) {
        String query = "SELECT id, proceedings, name, healthregister, description, descriptionShort, codemodeadmin, codepa, codeum, codelab FROM medicine WHERE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Medicine(rs.getInt("id"), rs.getString("proceedings"), rs.getString("name"),
                            rs.getString("healthregister"), rs.getString("description"), rs.getString("descriptionShort"),
                            rs.getInt("codemodeadmin"), rs.getInt("codepa"), rs.getInt("codeum"), rs.getInt("codelab")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Medicine> findAllMedicines() {
        String query = "SELECT id, proceedings, name, healthregister, description, descriptionShort, codemodeadmin, codepa, codeum, codelab FROM medicine";
        List<Medicine> medicines = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                medicines.add(new Medicine(rs.getInt("id"), rs.getString("proceedings"), rs.getString("name"),
                        rs.getString("healthregister"), rs.getString("description"), rs.getString("descriptionShort"),
                        rs.getInt("codemodeadmin"), rs.getInt("codepa"), rs.getInt("codeum"), rs.getInt("codelab")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }
}
