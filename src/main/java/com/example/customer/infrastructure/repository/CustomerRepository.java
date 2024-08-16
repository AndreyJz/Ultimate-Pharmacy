package com.example.customer.infrastructure.repository;

import com.example.customer.domain.entity.Customer;
import com.example.customer.domain.service.CustomerService;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CustomerRepository implements CustomerService {
    private Connection connection;
    
    public CustomerRepository(){
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
    public void createCustomer(Customer customer) {
        String query = "INSERT INTO customer (id,name,lastname,codecity,email,birthdate,lon,lat) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getCodeCity());
            ps.setString(5, customer.getEmail());
            ps.setDate(6, customer.getBirthdate());
            ps.setFloat(7, customer.getLon());
            ps.setFloat(8, customer.getLat());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer has been added!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customer SET name = ?,lastname = ?,codecity = ?,email = ?,birthdate = ?,lon = ?,lat = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getCodeCity());
            ps.setString(4, customer.getEmail());
            ps.setDate(5, customer.getBirthdate());
            ps.setFloat(6, customer.getLon());
            ps.setFloat(7, customer.getLat());
            ps.setString(8, customer.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer has been updated!", null, JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.addSuppressed(e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "An Error has occurred", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteCustomer(String id) {
        String query = "DELETE FROM customer WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        String query = "SELECT id,name,lastname,codecity,email,birthdate,lon,lat FROM customer WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setLastName(rs.getString("lastname"));
                customer.setCodeCity(rs.getString("codecity"));
                customer.setEmail(rs.getString("email"));
                customer.setBirthdate(rs.getDate("birthdate"));
                customer.setLon(rs.getFloat("lon"));
                customer.setLat(rs.getFloat("lat"));
                
                return Optional.of(customer);

            }
        } catch (SQLException e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> getAllCustomers() {
        String query = "SELECT id,name,lastname,codecity,email,birthdate,lon,lat FROM customer";
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setLastName(rs.getString("lastname"));
                customer.setCodeCity(rs.getString("codecity"));
                customer.setEmail(rs.getString("email"));
                customer.setBirthdate(rs.getDate("birthdate"));
                customer.setLon(rs.getFloat("lon"));
                customer.setLat(rs.getFloat("lat"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.addSuppressed(e);
        }
        return customers;
    }

    @Override
    public Optional<Customer> getCustomerByName(String name) {
        String query = "SELECT id,name,lastname,codecity,email,birthdate,lon,lat FROM customer WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setLastName(rs.getString("lastname"));
                customer.setCodeCity(rs.getString("codecity"));
                customer.setEmail(rs.getString("email"));
                customer.setBirthdate(rs.getDate("birthdate"));
                customer.setLon(rs.getFloat("lon"));
                customer.setLat(rs.getFloat("lat"));

                return Optional.of(customer);
            }
        } catch (SQLException e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }
    
}
