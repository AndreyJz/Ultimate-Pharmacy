package com.example.region.infrastructure.controller;

import com.example.city.domain.entity.City;
import com.example.country.aplication.FindCountryByIdUC;
import com.example.country.aplication.FindCountryByNameUC;
import com.example.country.aplication.ListAllCountriesUC;
import com.example.country.domain.entity.Country;
import com.example.region.aplication.*;
import com.example.region.domain.entity.Region;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class RegionController {
    private ListRegionsUC listRegionsUC;
    private FindRegionByNameUC findRegionByNameUC;
    private FindCountryByNameUC findCountryByNameUC;
    private ListAllCountriesUC listAllCountriesUC;
    private FindCountryByIdUC findCountryByIdUC;
    private FindRegionByIdDC findRegionByIdDC;
    private CreateRegionUC createRegionUC;
    private UpdateRegionUC updateRegionUC;
    private DeleteRegionUC deleteRegionUC;
    private String nameCountry;
    private String idCity;

    public RegionController(DeleteRegionUC deleteRegionUC, FindRegionByNameUC findRegionByNameUC, ListRegionsUC listRegionsUC) {
        this.deleteRegionUC = deleteRegionUC;
        this.findRegionByNameUC = findRegionByNameUC;
        this.listRegionsUC = listRegionsUC;
    }

    public RegionController(UpdateRegionUC updateRegionUC, FindRegionByNameUC findRegionByNameUC, ListRegionsUC listRegionsUC, FindCountryByNameUC findCountryByNameUC, ListAllCountriesUC listAllCountriesUC
    ) {
        this.updateRegionUC = updateRegionUC;
        this.findRegionByNameUC = findRegionByNameUC;
        this.listRegionsUC = listRegionsUC;
        this.findCountryByNameUC = findCountryByNameUC;
        this.listAllCountriesUC = listAllCountriesUC;
    }

    public RegionController(CreateRegionUC createRegionUC, FindCountryByNameUC findCountryByNameUC, ListAllCountriesUC listAllCountriesUC) {
        this.createRegionUC = createRegionUC;
        this.findCountryByNameUC = findCountryByNameUC;
        this.listAllCountriesUC = listAllCountriesUC;
    }

    public RegionController(FindRegionByIdDC findRegionByIdDC) {
        this.findRegionByIdDC = findRegionByIdDC;
    }

    public RegionController(FindRegionByNameUC findRegionByNameUC) {
        this.findRegionByNameUC = findRegionByNameUC;
    }

    public RegionController(ListRegionsUC listRegionsUC) {
        this.listRegionsUC = listRegionsUC;
    }

    public void createRegion() {
        JFrame myFrame = new JFrame("Create Region");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        List<Country> countries =  listAllCountriesUC.execute();

        JComboBox<String> countryField = new JComboBox<>();
        for (Country country : countries) {
            countryField.addItem(country.getName());
        }

        // Crear componentes
        JLabel imageLabel2 = new JLabel("code");
        JTextField nameField2 = new JTextField(20);
        JLabel imageLabel = new JLabel("name");
        JTextField nameField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        // Configurar el JLabel para la imagen
//        imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100)); // Ajusta la URL y el tamaño de la imagen

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Region region = new Region();
                nameCountry = (String) countryField.getSelectedItem();
                Optional<Country> country = findCountryByNameUC.execute(nameCountry);
                region.setName(nameField.getText());
                region.setId(nameField2.getText());
                region.setCodecountry(country.get().getCode());
                createRegionUC.execute(region);
                myFrame.dispose();
            }
        });

        // Crear un panel y añadir los componentes
        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(nameField);
        panel.add(imageLabel2);
        panel.add(nameField2);
        panel.add(countryField);
        panel.add(sendButton);

        // Añadir el panel al JFrame
        myFrame.add(panel);

        // Hacer visible el JFrame
        myFrame.setVisible(true);
    }

    public void updateRegion() {
        JFrame frame = new JFrame("Update Country");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<Region> regions =  listRegionsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Region region : regions) {
            myComboBox.addItem(region.getName());
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
                String nameRegion = (String) myComboBox.getSelectedItem();
                Optional<Region> region = findRegionByNameUC.execute(nameRegion);
                myPanel.setVisible(false);

                JLabel labelCode = new JLabel("Code : ");
                JTextField txtCode = new JTextField();
                labelCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelCode.setHorizontalAlignment(SwingConstants.CENTER);
                txtCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtCode.setText(region.get().getId());
                txtCode.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(region.get().getName());

                JLabel labelCountry = new JLabel("Country : ");
                JComboBox countryField = new JComboBox<>();

                List<Country> countries = listAllCountriesUC.execute();
                countries.forEach(c -> countryField.addItem(c.getName()));
                countryField.setSelectedItem(region.get().getCodecountry());

                JButton sendButton = new JButton("Done");

                panel.add(labelCode);
                panel.add(txtCode);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(labelCountry);
                panel.add(countryField);
                panel.add(new JLabel());
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);
                containerPanel.setVisible(true);

                frame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameCountry = countryField.getSelectedItem().toString();
                        Optional<Country> country = findCountryByNameUC.execute(nameCountry);

                        Region region = new Region();
                        region.setId(txtCode.getText());
                        System.out.println(txtCode.getText());
                        System.out.println(myComboBox.getSelectedItem().toString());
                        region.setCodecountry(country.get().getCode());
                        System.out.println(txtName.getText());
                        region.setName(txtName.getText());
                        updateRegionUC.execute(region);
                        frame.dispose();
                    }
                });

            }
        });
    }

    public void deleteRegion(){
        JFrame myFrame = new JFrame("Delete Region");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<Region> regions =  listRegionsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Region region : regions) {
            myComboBox.addItem(region.getName());
        }

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameRegion = (String) myComboBox.getSelectedItem();
                Optional<Region> region = findRegionByNameUC.execute(nameRegion);
                deleteRegionUC.execute(region.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Region has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Region> FindRegionByID() {
        String idRegion = JOptionPane.showInputDialog(null, "Insert The Code of The Region you're looking for: ");
        Optional<Region> region = findRegionByIdDC.execute(idRegion);
        if (region.isPresent()) {
            JOptionPane.showMessageDialog(null, "Region founded:\nID: " + region.get().getId() + "\nNombre: " + region.get().getName() + "\nCountryCode: " + region.get().getCodecountry(),
                    "Region's info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Region not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return region;
    }

    public List<Region> ListRegions() {
        List<Region> regions =  listRegionsUC.execute();
        showRegionsTable(regions);
        return regions;
    }

    public static void showRegionsTable(List<Region> regions) {
        String[] columns = {"Code", "Name", "CountryCode"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        regions.forEach(region -> {
            Object[] row = {region.getId(), region.getName(), region.getCodecountry()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Regions List", JOptionPane.PLAIN_MESSAGE);
    }
}

