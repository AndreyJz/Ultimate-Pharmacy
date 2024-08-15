package com.example.farmacy.infrastructure.controller;

import com.example.city.aplication.FindCitiesUC;
import com.example.city.aplication.FindCityByIdUC;
import com.example.city.aplication.FindCityByNameUC;
import com.example.city.domain.entity.City;
import com.example.farmacy.application.*;
import com.example.farmacy.domain.entity.Farmacy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class FarmacyController {
    private ListAllFarmaciesUC listAllFarmaciesUC;
    private FindFarmacyByNameUC findFarmacyByNameUC;
    private FindCityByNameUC findCityByNameUC;
    private FindCitiesUC findCitiesUC;
    private FindCityByIdUC findCityByIdUC;
    private FindFarmaciesByIdUC findFarmaciesByIdUC;
    private CreateFarmacyUC createFarmacyUC;
    private UpdateFarmacyUC updateFarmacyUC;
    private DeleteFarmacyUC deleteFarmacyUC;

    public FarmacyController(CreateFarmacyUC createFarmacyUC, FindCitiesUC findCitiesUC, FindCityByNameUC findCityByNameUC) {
        this.createFarmacyUC = createFarmacyUC;
        this.findCitiesUC = findCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
    }

    public FarmacyController(FindFarmaciesByIdUC findCustomersByIdUC) {
        this.findFarmaciesByIdUC = findCustomersByIdUC;
    }

    public FarmacyController(ListAllFarmaciesUC listAllCustomersUC) {
        this.listAllFarmaciesUC = listAllCustomersUC;
    }

    public FarmacyController(DeleteFarmacyUC dcuc, ListAllFarmaciesUC fcsuc, FindFarmacyByNameUC fcnuc) {
        this.deleteFarmacyUC = dcuc;
        this.listAllFarmaciesUC = fcsuc;
        this.findFarmacyByNameUC = fcnuc;
    }

    public FarmacyController(UpdateFarmacyUC updateCustomerUc, ListAllFarmaciesUC listAllCustomersUC, FindFarmacyByNameUC findCustomerByNameUC, FindCitiesUC findCitiesUC, FindCityByNameUC findCityByNameUC, FindCityByIdUC findCityByIdUC) {
        this.updateFarmacyUC = updateCustomerUc;
        this.listAllFarmaciesUC = listAllCustomersUC;
        this.findFarmacyByNameUC = findCustomerByNameUC;
        this.findCitiesUC = findCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
        this.findCityByIdUC = findCityByIdUC;
    }

    public void createFarmacy() {
        JFrame myFrame = new JFrame("Create Farmacy");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

//        JLabel labelID = new JLabel("ID : ");
//        JTextField txtID = new JTextField();
//        labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
//        labelID.setHorizontalAlignment(SwingConstants.CENTER);
//        txtID.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelName = new JLabel("Name : ");
        JTextField txtName = new JTextField();
        labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelAdress = new JLabel("Adress : ");
        JTextField txtAdress = new JTextField();
        labelAdress.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelAdress.setHorizontalAlignment(SwingConstants.CENTER);
        txtAdress.setFont(new Font("Calibri", Font.PLAIN, 15));

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

        JLabel labelNeighborhood = new JLabel("City : ");

        List<City> cities =  findCitiesUC.execute();

        JComboBox<String> neighborhoodBox = new JComboBox<>();
        for (City city : cities  ) {
            neighborhoodBox.addItem(city.getName());
        }

        labelNeighborhood.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelNeighborhood.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelLogo = new JLabel("Logo : ");
        JTextField txtLogo = new JTextField();
        labelLogo.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        txtLogo.setFont(new Font("Calibri", Font.PLAIN, 15));


        JButton sendButton = new JButton("Enviar");

//        panel.add(labelID);
//        panel.add(txtID);
        panel.add(labelName);
        panel.add(txtName);
        panel.add(labelAdress);
        panel.add(txtAdress);
        panel.add(labelLon);
        panel.add(txtLon);
        panel.add(labelLat);
        panel.add(txtLat);
        panel.add(labelNeighborhood);
        panel.add(neighborhoodBox);
        panel.add(labelLogo);
        panel.add(txtLogo);
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
                Farmacy customer = new Farmacy();
//                customer.setId(txtID.getText());
                customer.setName(txtName.getText());
                customer.setAdress(txtAdress.getText());
                customer.setLon(Float.parseFloat(txtLon.getText()));
                customer.setLat(Float.parseFloat(txtLat.getText()));
                customer.setCodeCity(city.get().getId());
                customer.setLogo(txtLogo.getText());
                createFarmacyUC.execute(customer);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Farmacy has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public void updateFarmacy() {
        JFrame myFrame = new JFrame("Update Farmacy");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton nextButton = new JButton("Next ->");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        List<Farmacy> farmacies =  listAllFarmaciesUC.execute();

        JComboBox<String> FarmaciesBox = new JComboBox<>();
        for (Farmacy farmacy : farmacies) {
            FarmaciesBox.addItem(farmacy.getName());
        }

        myPanel.add(FarmaciesBox);
        myPanel.add(nextButton);
        myFrame.add(myPanel);

        myPanel.setVisible(true);

        myFrame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFarmacy = (String) FarmaciesBox.getSelectedItem();
                Optional<Farmacy> farmacy = findFarmacyByNameUC.execute(nameFarmacy);
                myPanel.setVisible(false);


                JLabel labelID = new JLabel("ID : ");
                JTextField txtID = new JTextField();
                labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelID.setHorizontalAlignment(SwingConstants.CENTER);
                txtID.setFont(new Font("Calibri", Font.PLAIN, 15));
                System.out.println(farmacy.get().getId());
                txtID.setText(farmacy.get().getId());
                txtID.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(farmacy.get().getName());

                JLabel labelAdress = new JLabel("Adress : ");
                JTextField txtAdress = new JTextField();
                labelAdress.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelAdress.setHorizontalAlignment(SwingConstants.CENTER);
                txtAdress.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtAdress.setText(farmacy.get().getAdress());

                JLabel labelLon = new JLabel("Lon : ");
                JTextField txtLon = new JTextField();
                labelLon.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLon.setHorizontalAlignment(SwingConstants.CENTER);
                txtLon.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLon.setText(String.valueOf(farmacy.get().getLon()));

                JLabel labelLat = new JLabel("Lat : ");
                JTextField txtLat = new JTextField();
                labelLat.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLat.setHorizontalAlignment(SwingConstants.CENTER);
                txtLat.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLat.setText(String.valueOf(farmacy.get().getLat()));

                JLabel labelNeighborhood = new JLabel("City : ");

                List<City> cities =  findCitiesUC.execute();

                JComboBox<String> neighborhoodBox = new JComboBox<>();
                for (City city : cities  ) {
                    neighborhoodBox.addItem(city.getName());
                }

                Optional<City> city = findCityByIdUC.execute(farmacy.get().getCodeCity());
                neighborhoodBox.setSelectedItem(city.get().getName());

                labelNeighborhood.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelNeighborhood.setHorizontalAlignment(SwingConstants.CENTER);

                JLabel labelLogo = new JLabel("Logo : ");
                JTextField txtLogo = new JTextField();
                labelLogo.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
                txtLogo.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLogo.setText(farmacy.get().getLogo());


                JButton sendButton = new JButton("Save");

                panel.add(labelID);
                panel.add(txtID);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(labelAdress);
                panel.add(txtAdress);
                panel.add(labelLon);
                panel.add(txtLon);
                panel.add(labelLat);
                panel.add(txtLat);
                panel.add(labelNeighborhood);
                panel.add(neighborhoodBox);
                panel.add(labelLogo);
                panel.add(txtLogo);
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
                        Farmacy customer = new Farmacy();
                        customer.setId(txtID.getText());
                        customer.setName(txtName.getText());
                        customer.setAdress(txtAdress.getText());
                        customer.setLon(Float.parseFloat(txtLon.getText()));
                        customer.setLat(Float.parseFloat(txtLat.getText()));
                        customer.setCodeCity(city.get().getId());
                        customer.setLogo(txtLogo.getText());
                        updateFarmacyUC.execute(customer);
                        myFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Farmacy has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });
            }
        });
    }

    public void deleteFarmacy(){
        JFrame myFrame = new JFrame("Delete Farmacy");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Delete ->");

        List<Farmacy> farmacies =  listAllFarmaciesUC.execute();

        JComboBox<String> myFarmaciesComboBox = new JComboBox<>();
        for (Farmacy customer : farmacies) {
            myFarmaciesComboBox.addItem(customer.getName());
        }


        myPanel.add(myFarmaciesComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCustomer = (String) myFarmaciesComboBox.getSelectedItem();
                Optional<Farmacy> customer = findFarmacyByNameUC.execute(nameCustomer);
                deleteFarmacyUC.execute(customer.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Farmacy has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Farmacy> FindFarmacyByID() {
        String idCustomer = JOptionPane.showInputDialog(null, "Insert the id of the Farmacy of id: ");
        Optional<Farmacy> customer = findFarmaciesByIdUC.execute(idCustomer);
        if (customer.isPresent()) {
            JOptionPane.showMessageDialog(null, "Farmacy founded:\nID: " + customer.get().getId() + "\nNombre: " + customer.get().getName() + "\nAdress: " + customer.get().getAdress() + "\nLon : " + customer.get().getLon() + "\nLat : " + customer.get().getLat() + "\nCity ID: " + customer.get().getCodeCity() + "\nLogo: " + customer.get().getLogo(),
                    "Farmacy's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Farmacy not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }

    public List<Farmacy> ListFarmacies() {
        List<Farmacy> customers =  listAllFarmaciesUC.execute();
        showFarmaciesTable(customers);
        return customers;
    }

    public static void showFarmaciesTable(List<Farmacy> customers) {
        String[] columns = {"ID", "Name", "Adress", "Lon", "Lat", "CityID", "Logo" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        customers.forEach(customer -> {
            Object[] row = {customer.getId(), customer.getName(), customer.getAdress() , customer.getLon(), customer.getLat(), customer.getCodeCity(), customer.getLogo()};
            model.addRow(row);
            System.out.println(customer.getLogo());
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Farmacies List", JOptionPane.PLAIN_MESSAGE);
    }
}
