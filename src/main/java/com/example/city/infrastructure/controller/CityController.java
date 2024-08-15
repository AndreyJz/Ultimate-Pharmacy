package com.example.city.infrastructure.controller;

import com.example.city.aplication.*;
import com.example.city.domain.entity.City;
import com.example.country.aplication.FindCountryByIdUC;
import com.example.country.aplication.ListAllCountriesUC;
import com.example.country.aplication.FindCountryByNameUC;
import com.example.country.domain.entity.Country;
import com.example.region.aplication.*;
import com.example.region.domain.entity.Region;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class CityController {
    private FindCitiesUC listCitiesUC;
    private FindCityByNameUC findCityByNameUC;
    private FindRegionByNameUC findRegionByNameUC;
    private ListRegionsUC listRegionsUC;
    private FindRegionByIdDC findRegionByIdUC;
    private FindCityByIdUC findCityByIdDC;
    private CreateCityUC createCityUC;
    private UpdateCityUC updateCityUC;
    private DeleteCityUC deleteCityUC;
    private String nameCity;
    private String idCity;

    public CityController(CreateCityUC createCityUC, ListRegionsUC listRegionsUC, FindRegionByNameUC findRegionByNameUC) {
        this.createCityUC = createCityUC;
        this.listRegionsUC = listRegionsUC;
        this.findRegionByNameUC = findRegionByNameUC;
    }

    public CityController(FindCityByIdUC findCityByIdUC) {
        this.findCityByIdDC = findCityByIdUC;
    }

    public CityController(FindCitiesUC listCitiesUC) {
        this.listCitiesUC = listCitiesUC;
    }

    public CityController(UpdateCityUC updateCityUC, FindCitiesUC listCitiesUC, FindCityByNameUC findCityByNameUC, ListRegionsUC listRegionsUC, FindRegionByNameUC findRegionByNameUC) {
        this.updateCityUC = updateCityUC;
        this.listCitiesUC = listCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
        this.listRegionsUC = listRegionsUC;
        this.findRegionByNameUC = findRegionByNameUC;
    }

    public CityController(DeleteCityUC dcuc, FindCitiesUC fcsuc, FindCityByNameUC fcnuc) {
        this.deleteCityUC = dcuc;
        this.listCitiesUC = fcsuc;
        this.findCityByNameUC = fcnuc;
    }

    public void createCity() {
        JFrame myFrame = new JFrame("Create City");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        List<Region> regions =  listRegionsUC.execute();

        JComboBox<String> regionField = new JComboBox<>();
        for (Region region : regions) {
            regionField.addItem(region.getName());
        }

        // Crear componentes
        JLabel imageLabel2 = new JLabel("code");
        JTextField nameField2 = new JTextField(20);
        JLabel imageLabel = new JLabel("name");
        JTextField nameField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                City city = new City();
                String nameRegion = (String) regionField.getSelectedItem();
                Optional<Region> region = findRegionByNameUC.execute(nameRegion);
                city.setName(nameField.getText());
                city.setId(nameField2.getText());
                city.setCodereg(region.get().getId());
                createCityUC.execute(city);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "City has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(nameField);
        panel.add(imageLabel2);
        panel.add(nameField2);
        panel.add(regionField);
        panel.add(sendButton);

        myFrame.add(panel);

        myFrame.setVisible(true);
    }

    public void updateCity() {
        JFrame frame = new JFrame("Update Country");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<City> cities =  listCitiesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (City city : cities) {
            myComboBox.addItem(city.getName());
        }

        // countries.forEach(c -> myComboBox.addItem(c.getName()));
        JPanel myPanel = new JPanel();

        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Go Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        myPanel.add(myComboBox);
        myPanel.add(nextButton);
        myPanel.add(backButton);
        frame.add(myPanel);

        myPanel.setVisible(true);
        frame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCity = (String) myComboBox.getSelectedItem();
                Optional<City> city = findCityByNameUC.execute(nameCity);
                myPanel.setVisible(false);

                JLabel labelCode = new JLabel("Code : ");
                JTextField txtCode = new JTextField();
                labelCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelCode.setHorizontalAlignment(SwingConstants.CENTER);
                txtCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtCode.setText(city.get().getId());
                txtCode.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(city.get().getName());

                JLabel labelRegion = new JLabel("Region : ");
                JComboBox regionField = new JComboBox<>();

                List<Region> regions = listRegionsUC.execute();
                regions.forEach(c -> regionField.addItem(c.getName()));
                regionField.setSelectedItem(city.get().getCodereg());

                JButton sendButton = new JButton("Done");

                panel.add(labelCode);
                panel.add(txtCode);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(labelRegion);
                panel.add(regionField);
                panel.add(new JLabel());
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);
                containerPanel.setVisible(true);

                frame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameRegion = regionField.getSelectedItem().toString();
                        Optional<Region> region = findRegionByNameUC.execute(nameRegion);

                        City city = new City();
                        city.setId(txtCode.getText());
                        city.setCodereg(region.get().getId());
                        city.setName(txtName.getText());
                        updateCityUC.execute(city);
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "City has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });

            }
        });
    }

    public void deleteCity(){
        JFrame myFrame = new JFrame("Delete City");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<City> cities =  listCitiesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (City city : cities) {
            myComboBox.addItem(city.getName());
        }

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCity = (String) myComboBox.getSelectedItem();
                Optional<City> city = findCityByNameUC.execute(nameCity);
                deleteCityUC.execute(city.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "City has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<City> FindCityByID() {
        String idCity = JOptionPane.showInputDialog(null, "Insert The Code of The City you're looking for: ");
        Optional<City> city = findCityByIdDC.execute(idCity);
        if (city.isPresent()) {
            JOptionPane.showMessageDialog(null, "City founded:\nID: " + city.get().getId() + "\nNombre: " + city.get().getName() + "\nCountryRegion: " + city.get().getCodereg(),
                    "City's info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "City not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return city;
    }

    public List<City> ListCities() {
        List<City> cities =  listCitiesUC.execute();
        showRegionsTable(cities);
        return cities;
    }

    public static void showRegionsTable(List<City> cities) {
        String[] columns = {"Code", "Name", "CountryRegion"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        cities.forEach(region -> {
            Object[] row = {region.getId(), region.getName(), region.getCodereg()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "City List", JOptionPane.PLAIN_MESSAGE);
    }
}
