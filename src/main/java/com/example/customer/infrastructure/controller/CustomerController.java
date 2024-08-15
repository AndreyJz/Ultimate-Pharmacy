package com.example.customer.infrastructure.controller;

import com.example.city.aplication.FindCitiesUC;
import com.example.city.aplication.FindCityByIdUC;
import com.example.city.aplication.FindCityByNameUC;
import com.example.city.domain.entity.City;
import com.example.customer.application.*;
import com.example.customer.domain.entity.Customer;
import com.example.laboratory.domain.entity.Laboratory;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class CustomerController {
    private ListAllCustomersUC listAllCustomersUC;
    private FindCustomerByNameUC findCustomerByNameUC;
    private FindCityByNameUC findCityByNameUC;
    private FindCitiesUC findCitiesUC;
    private FindCityByIdUC findCityByIdUC;
    private FindCustomersByIdUC findCustomersByIdUC;
    private CreateCustomerUC createCustomerUC;
    private UpdateCustomerUc updateCustomerUc;
    private DeleteCustomerUC deleteCustomerUC;

    public CustomerController(CreateCustomerUC createCustomerUC, FindCitiesUC findCitiesUC, FindCityByNameUC findCityByNameUC) {
        this.createCustomerUC = createCustomerUC;
        this.findCitiesUC = findCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
    }

    public CustomerController(FindCustomersByIdUC findCustomersByIdUC) {
        this.findCustomersByIdUC = findCustomersByIdUC;
    }

    public CustomerController(ListAllCustomersUC listAllCustomersUC) {
        this.listAllCustomersUC = listAllCustomersUC;
    }

    public CustomerController(DeleteCustomerUC dcuc, ListAllCustomersUC fcsuc, FindCustomerByNameUC fcnuc) {
        this.deleteCustomerUC = dcuc;
        this.listAllCustomersUC = fcsuc;
        this.findCustomerByNameUC = fcnuc;
    }

    public CustomerController(UpdateCustomerUc updateCustomerUc, ListAllCustomersUC listAllCustomersUC, FindCustomerByNameUC findCustomerByNameUC, FindCitiesUC findCitiesUC, FindCityByNameUC findCityByNameUC, FindCityByIdUC findCityByIdUC) {
        this.updateCustomerUc = updateCustomerUc;
        this.listAllCustomersUC = listAllCustomersUC;
        this.findCustomerByNameUC = findCustomerByNameUC;
        this.findCitiesUC = findCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
        this.findCityByIdUC = findCityByIdUC;
    }

    public void createMedicine() {
        JFrame myFrame = new JFrame("Create Customer");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        JLabel labelID = new JLabel("ID : ");
        JTextField txtID = new JTextField();
        labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelID.setHorizontalAlignment(SwingConstants.CENTER);
        txtID.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelName = new JLabel("Name : ");
        JTextField txtName = new JTextField();
        labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelLastName = new JLabel("Last Name : ");
        JTextField txtLastName = new JTextField();
        labelLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelLastName.setHorizontalAlignment(SwingConstants.CENTER);
        txtLastName.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelNeighborhood = new JLabel("City : ");

        List<City> cities =  findCitiesUC.execute();

        JComboBox<String> neighborhoodBox = new JComboBox<>();
        for (City city : cities  ) {
            neighborhoodBox.addItem(city.getName());
        }

        labelNeighborhood.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelNeighborhood.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelEmail = new JLabel("Email : ");
        JTextField txtEmail = new JTextField();
        labelEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelBirthdate = new JLabel("Birthdate : ");
        JDateChooser dateBirthDate = new JDateChooser ();
        labelBirthdate.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
        dateBirthDate.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelLon = new JLabel("Lon : ");
        JTextField txtLon = new JTextField();
        labelLon.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelLon.setHorizontalAlignment(SwingConstants.CENTER);
        txtLon.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelLat = new JLabel("Lat : ");
        JTextField txtLat = new JTextField();
        labelLat.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelLat.setHorizontalAlignment(SwingConstants.CENTER);
        txtLat.setFont(new Font("Calibri", Font.PLAIN, 15));

        JButton sendButton = new JButton("Enviar");

        panel.add(labelID);
        panel.add(txtID);
        panel.add(labelName);
        panel.add(txtName);
        panel.add(labelLastName);
        panel.add(txtLastName);
        panel.add(labelNeighborhood);
        panel.add(neighborhoodBox);
        panel.add(labelEmail);
        panel.add(txtEmail);
        panel.add(labelBirthdate);
        panel.add(dateBirthDate);
        panel.add(labelLon);
        panel.add(txtLon);
        panel.add(labelLat);
        panel.add(txtLat);
        panel.add(new JLabel());  // Placeholder for alignment
        panel.add(sendButton);

        JPanel containerPanel = new JPanel();
        containerPanel.add(panel);

        myFrame.add(containerPanel);

        myFrame.setVisible(true);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCity = (String) neighborhoodBox.getSelectedItem();
                Optional<City> city = findCityByNameUC.execute(nameCity);
                Customer customer = new Customer();
                customer.setId(txtID.getText());
                customer.setName(txtName.getText());
                customer.setLastName(txtLastName.getText());
                customer.setCodeCity(city.get().getId());
                customer.setEmail(txtEmail.getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                customer.setBirthdate(Date.valueOf(dateFormat.format(dateBirthDate.getDate())));
                customer.setLon(Float.parseFloat(txtLon.getText()));
                customer.setLat(Float.parseFloat(txtLat.getText()));
                createCustomerUC.execute(customer);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Customer has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public void updateCustomer() {
        JFrame myFrame = new JFrame("Update Customer");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton nextButton = new JButton("Next ->");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        List<Customer> customers =  listAllCustomersUC.execute();

        JComboBox<String> customersBox = new JComboBox<>();
        for (Customer customer : customers) {
            customersBox.addItem(customer.getName());
        }

        myPanel.add(customersBox);
        myPanel.add(nextButton);
        myFrame.add(myPanel);

        myPanel.setVisible(true);

        myFrame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCustomer = (String) customersBox.getSelectedItem();
                Optional<Customer> customer = findCustomerByNameUC.execute(nameCustomer);
                myPanel.setVisible(false);


                JLabel labelID = new JLabel("ID : ");
                JTextField txtID = new JTextField();
                labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelID.setHorizontalAlignment(SwingConstants.CENTER);
                txtID.setFont(new Font("Calibri", Font.PLAIN, 15));
                System.out.println(customer.get().getId());
                txtID.setText(customer.get().getId());

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(customer.get().getName());

                JLabel labelLastName = new JLabel("Last Name : ");
                JTextField txtLastName = new JTextField();
                labelLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLastName.setHorizontalAlignment(SwingConstants.CENTER);
                txtLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLastName.setText(customer.get().getLastName());

                JLabel labelNeighborhood = new JLabel("City : ");

                List<City> cities =  findCitiesUC.execute();

                JComboBox<String> neighborhoodBox = new JComboBox<>();
                for (City city : cities  ) {
                    neighborhoodBox.addItem(city.getName());
                }

                Optional<City> city = findCityByIdUC.execute(customer.get().getCodeCity());
                neighborhoodBox.setSelectedItem(city.get().getName());

                labelNeighborhood.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelNeighborhood.setHorizontalAlignment(SwingConstants.CENTER);

                JLabel labelEmail = new JLabel("Email : ");
                JTextField txtEmail = new JTextField();
                labelEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
                txtEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtEmail.setText(customer.get().getEmail());

                JLabel labelBirthdate = new JLabel("Birthdate : ");
                JDateChooser dateBirthDate = new JDateChooser();
                labelBirthdate.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
                dateBirthDate.setFont(new Font("Calibri", Font.PLAIN, 15));

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date birthDate = simpleDateFormat.parse(String.valueOf(customer.get().getBirthdate()));
                    dateBirthDate.setDate(birthDate);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                JLabel labelLon = new JLabel("Lon : ");
                JTextField txtLon = new JTextField();
                labelLon.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLon.setHorizontalAlignment(SwingConstants.CENTER);
                txtLon.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLon.setText(String.valueOf(customer.get().getLon()));

                JLabel labelLat = new JLabel("Lat : ");
                JTextField txtLat = new JTextField();
                labelLat.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLat.setHorizontalAlignment(SwingConstants.CENTER);
                txtLat.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLat.setText(String.valueOf(customer.get().getLat()));

                JButton sendButton = new JButton("Save");

                panel.add(labelID);
                panel.add(txtID);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(labelLastName);
                panel.add(txtLastName);
                panel.add(labelNeighborhood);
                panel.add(neighborhoodBox);
                panel.add(labelEmail);
                panel.add(txtEmail);
                panel.add(labelBirthdate);
                panel.add(dateBirthDate);
                panel.add(labelLon);
                panel.add(txtLon);
                panel.add(labelLat);
                panel.add(txtLat);
                panel.add(new JLabel());  // Placeholder for alignment
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);
                containerPanel.setVisible(true);

                myFrame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameCity = (String) neighborhoodBox.getSelectedItem();
                        Optional<City> city = findCityByNameUC.execute(nameCity);
                        Customer customer = new Customer();
                        customer.setId(txtID.getText());
                        customer.setName(txtName.getText());
                        customer.setLastName(txtLastName.getText());
                        customer.setCodeCity(city.get().getId());
                        customer.setEmail(txtEmail.getText());
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        customer.setBirthdate(Date.valueOf(dateFormat.format(dateBirthDate.getDate())));
                        customer.setLon(Float.parseFloat(txtLon.getText()));
                        customer.setLat(Float.parseFloat(txtLat.getText()));
                        updateCustomerUc.execute(customer);
                        myFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Customer has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });
            }
        });
    }

    public void deleteCustomer(){
        JFrame myFrame = new JFrame("Delete Laboratory");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<Customer> customers =  listAllCustomersUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Customer customer : customers) {
            myComboBox.addItem(customer.getName());
        }


        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCustomer = (String) myComboBox.getSelectedItem();
                Optional<Customer> customer = findCustomerByNameUC.execute(nameCustomer);
                deleteCustomerUC.execute(customer.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Customer has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Customer> FindCustomerByID() {
        String idCustomer = JOptionPane.showInputDialog(null, "Insert the id of the Customer of id: ");
        Optional<Customer> customer = findCustomersByIdUC.execute(idCustomer);
        if (customer.isPresent()) {
            JOptionPane.showMessageDialog(null, "Customer founded:\nID: " + customer.get().getId() + "\nNombre: " + customer.get().getName() + "\nLastName: " + "\nCity ID: " + customer.get().getCodeCity() + customer.get().getLastName() + "\nEmail: " + customer.get().getEmail() + "\nBirthDate: " + customer.get().getBirthdate() + "\nLon : " + customer.get().getLon() + "\nLat : " + customer.get().getLat(),
                    "Customer Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Customer not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }

    public List<Customer> ListCustomers() {
        List<Customer> customers =  listAllCustomersUC.execute();
        showCustomersTable(customers);
        return customers;
    }

    public static void showCustomersTable(List<Customer> customers) {
        String[] columns = {"ID", "Name", "LastName", "CityID", "Email", "BirthDate", "Lon", "Lat"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        customers.forEach(customer -> {
            Object[] row = {customer.getId(), customer.getName(), customer.getLastName(), customer.getCodeCity(), customer.getEmail(), customer.getBirthdate(), customer.getLon(), customer.getLat()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Customers List", JOptionPane.PLAIN_MESSAGE);
    }
}
