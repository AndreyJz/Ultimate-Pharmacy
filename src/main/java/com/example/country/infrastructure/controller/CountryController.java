package com.example.country.infrastructure.controller;

import com.example.country.aplication.*;
import com.example.country.domain.entity.Country;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class CountryController {
    private CreateCountryUC createCountryUC;
    private UpdateCountryUC updateCountryUC;
    private DeleteCountryUC deleteCountryUC;
    private FindCountryByIdUC findCountryByIdUC;
    private FindCountryByNameUC findCountryByNameUC;
    private ListAllCountriesUC listAllCountriesUC;

    public CountryController(CreateCountryUC createCountryUC) {
        this.createCountryUC = createCountryUC;
    }

    public CountryController(ListAllCountriesUC listAllCountriesUC) {
        this.listAllCountriesUC = listAllCountriesUC;
    }

    public CountryController(FindCountryByNameUC findCountryByName) {
        this.findCountryByNameUC = findCountryByName;
    }

    public CountryController(FindCountryByIdUC findCountryById) {
        this.findCountryByIdUC = findCountryById;
    }

    public CountryController(UpdateCountryUC updateCountryUC, ListAllCountriesUC listAllCountriesUC, FindCountryByNameUC findCountryByName) {
        this.updateCountryUC = updateCountryUC;
        this.listAllCountriesUC = listAllCountriesUC;
        this.findCountryByNameUC = findCountryByName;
    }

    public CountryController(DeleteCountryUC deleteCountryUC, ListAllCountriesUC listAllCountriesUC, FindCountryByNameUC findCountryByName) {
        this.deleteCountryUC = deleteCountryUC;
        this.listAllCountriesUC = listAllCountriesUC;
        this.findCountryByNameUC = findCountryByName;
    }

    public void CreateCountry() {
        JFrame myFrame = new JFrame("Create Customer");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 100));

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField codeField = new JTextField(20);
        JLabel imageLabel = new JLabel("Name: ");
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField nameField = new JTextField(20);
        JButton sendButton = new JButton("Done");
        JButton backButton = new JButton("Go Back");

//        imageLabel.setIcon((Icon) new ImageIcon("src/main/resources/images/country-5.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Country country = new Country();
                country.setCode(codeField.getText());
                country.setName(nameField.getText());
                createCountryUC.execute(country);
                myFrame.dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.dispose();
            }
        });

        panel.add(idLabel);
        panel.add(codeField);
        panel.add(imageLabel);
        panel.add(nameField);
        panel.add(sendButton);
        panel.add(backButton);

        JPanel containerPanel = new JPanel();
        containerPanel.add(panel);

        myFrame.add(containerPanel);

        myFrame.setVisible(true);
    }

    public void UpdateCountry() {
        JFrame frame = new JFrame("Update Country");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<Country> countries =  listAllCountriesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Country country : countries) {
            myComboBox.addItem(country.getName());
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
                String nameCountry = (String) myComboBox.getSelectedItem();
                Optional<Country> country = findCountryByNameUC.execute(nameCountry);
                myPanel.setVisible(false);

                JLabel labelCode = new JLabel("Code : ");
                JTextField txtCode = new JTextField();
                labelCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelCode.setHorizontalAlignment(SwingConstants.CENTER);
                txtCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtCode.setText(country.get().getCode());
                txtCode.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(country.get().getName());

                JButton sendButton = new JButton("Done");

                panel.add(labelCode);
                panel.add(txtCode);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(new JLabel());
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);
                containerPanel.setVisible(true);

                frame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Country country = new Country();
                        country.setCode(txtCode.getText());
                        country.setName(txtName.getText());
                        updateCountryUC.execute(country);
                        frame.dispose();
                    }
                });

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void DeleteCountry(){
        JFrame myFrame = new JFrame("Delete Country");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<Country> countries =  listAllCountriesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Country country : countries) {
            myComboBox.addItem(country.getName());
        }

        // countries.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameCountry = (String) myComboBox.getSelectedItem();
                Optional<Country> country = findCountryByNameUC.execute(nameCountry);
                deleteCountryUC.execute(country.get().getCode());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Country has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Country> FindCountryByID() {
        String idCountry = JOptionPane.showInputDialog(null, "Insert The Code of The Country you're looking for: ");
        Optional<Country> country = findCountryByIdUC.execute(idCountry);
        if (country.isPresent()) {
            JOptionPane.showMessageDialog(null, "Country founded:\nID: " + country.get().getCode() + "\nNombre: " + country.get().getName(),
                    "Country's info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Country not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return country;
    }

    public List<Country> ListCountries() {
        List<Country> countries =  listAllCountriesUC.execute();
        showCountriesTable(countries);
        return countries;
    }

    public static void showCountriesTable(List<Country> countries) {
        String[] columns = {"Code", "Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        countries.forEach(country -> {
            Object[] row = {country.getCode(), country.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Countries List", JOptionPane.PLAIN_MESSAGE);
    }
}
