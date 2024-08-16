package com.example.unitmeasurement.infrastructure.controller;

import com.example.country.aplication.FindCountryByIdUC;
import com.example.country.aplication.FindCountryByNameUC;
import com.example.country.aplication.ListAllCountriesUC;
import com.example.country.domain.entity.Country;
import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.unitmeasurement.application.*;
import com.example.unitmeasurement.domain.entity.UnitMeasurement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class UnitMeasurementController {
    private CreateUnitMeasurementUC createUnitMeasurementUC;
    private UpdateUnitMeasurementUC updateUnitMeasurementUC;
    private DeleteUnitMeasurementUC deleteUnitMeasurementUC;
    private FindUnitMeasurementByIdUC findUnitMeasurementByIdUC;
    private FindUnitMeasurementByNameUC findUnitMeasurementByNameUC;
    private ListUnitMeasurementsUC listUnitMeasurementsUC;

    public UnitMeasurementController(DeleteUnitMeasurementUC deleteUnitMeasurementUC) {
        this.deleteUnitMeasurementUC = deleteUnitMeasurementUC;
    }

    public UnitMeasurementController(CreateUnitMeasurementUC createUnitMeasurementUC) {
        this.createUnitMeasurementUC = createUnitMeasurementUC;
    }

    public UnitMeasurementController(UpdateUnitMeasurementUC updateUnitMeasurementUC, ListUnitMeasurementsUC listUnitMeasurementsUC, FindUnitMeasurementByNameUC findUnitMeasurementByNameUC) {
        this.updateUnitMeasurementUC = updateUnitMeasurementUC;
        this.listUnitMeasurementsUC = listUnitMeasurementsUC;
        this.findUnitMeasurementByNameUC = findUnitMeasurementByNameUC;
    }

    public UnitMeasurementController(FindUnitMeasurementByIdUC findUnitMeasurementByIdUC) {
        this.findUnitMeasurementByIdUC = findUnitMeasurementByIdUC;
    }

    public UnitMeasurementController(ListUnitMeasurementsUC listUnitMeasurementsUC) {
        this.listUnitMeasurementsUC = listUnitMeasurementsUC;
    }

    public UnitMeasurementController(FindUnitMeasurementByNameUC findUnitMeasurementByNameUC) {
        this.findUnitMeasurementByNameUC = findUnitMeasurementByNameUC;
    }

    public UnitMeasurementController(DeleteUnitMeasurementUC du, ListUnitMeasurementsUC lu, FindUnitMeasurementByNameUC fu) {
        this.deleteUnitMeasurementUC = du;
        this.listUnitMeasurementsUC = lu;
        this.findUnitMeasurementByNameUC = fu;
    }

    public void createUnitMeasurement() {
        JFrame myFrame = new JFrame("Create Unit Measurement");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        // Crear componentes
        JLabel descriptionLabel = new JLabel("Name:");
        JTextField descriptionField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnitMeasurement unitMeasurement = new UnitMeasurement();
                unitMeasurement.setName(descriptionField.getText());
                createUnitMeasurementUC.execute(unitMeasurement);
                myFrame.dispose();
            }
        });

        // Crear un panel y añadir los componentes
        JPanel panel = new JPanel();
        panel.add(descriptionLabel);
        panel.add(descriptionField);
        panel.add(sendButton);

        // Añadir el panel al JFrame
        myFrame.add(panel);

        // Hacer visible el JFrame
        myFrame.setVisible(true);
    }

    public void updateUnitMeasurement() {
        JFrame frame = new JFrame("Update Unit Measurement");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<UnitMeasurement> unitMeasurements =  listUnitMeasurementsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (UnitMeasurement unitMeasurement : unitMeasurements) {
            myComboBox.addItem(unitMeasurement.getName());
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
                String nameUnit = (String) myComboBox.getSelectedItem();
                Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByNameUC.execute(nameUnit);
                myPanel.setVisible(false);

                JLabel labelCode = new JLabel("ID : ");
                JTextField txtCode = new JTextField();
                labelCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelCode.setHorizontalAlignment(SwingConstants.CENTER);
                txtCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtCode.setText(String.valueOf(unitMeasurement.get().getId()));
                txtCode.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(unitMeasurement.get().getName());

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
                        UnitMeasurement unitMeasurement1 = new UnitMeasurement();
                        unitMeasurement1.setId(Integer.parseInt(txtCode.getText()));
                        unitMeasurement1.setName(txtName.getText());
                        updateUnitMeasurementUC.execute(unitMeasurement1);
                        frame.dispose();
                    }
                });

            }
        });
    }

    public void deleteUnitMeasurement() {
        JFrame frame = new JFrame("Delete Country");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();

        JComboBox<String> idComboBox = new JComboBox<>();
        JButton submitButton = new JButton("Delete");

        listUnitMeasurementsUC.execute().forEach(unitMeasurement -> idComboBox.addItem(unitMeasurement.getName()));

        myPanel.add(new JLabel("Unit Measurement:"));

        myPanel.add(idComboBox);
        myPanel.add(submitButton);
        frame.add(myPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameUnit = (String) idComboBox.getSelectedItem();
                Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByNameUC.execute(nameUnit);
                deleteUnitMeasurementUC.execute(unitMeasurement.get().getId());
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Unit Measurement has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    public void findUnitMeasurementById() {
        Integer idUnit = Integer.valueOf(JOptionPane.showInputDialog(null, "Insert The Code of The Unit you're looking for: "));
        Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByIdUC.execute(idUnit);
        if (unitMeasurement.isPresent()) {
            JOptionPane.showMessageDialog(null, "Unit founded:\nID: " + unitMeasurement.get().getId() + "\nName: " + unitMeasurement.get().getName(),
                    "Unit's info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Unit not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void findUnitMeasurementByName() {
        JFrame frame = new JFrame("Find Unit Measurement by Name");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 2));

        JTextField nameField = new JTextField();
        JButton submitButton = new JButton("Submit");

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel());
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByNameUC.execute(name);
                if (unitMeasurement.isPresent()) {
                    JOptionPane.showMessageDialog(frame,
                            "ID: " + unitMeasurement.get().getId() + "\nName: " + unitMeasurement.get().getName());
                } else {
                    JOptionPane.showMessageDialog(frame, "UnitMeasurement not found.");
                }
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void ListUnitMeasurement() {
        List<UnitMeasurement> unitMeasurements =  listUnitMeasurementsUC.execute();
        showUnitsTable(unitMeasurements);
    }

    public static void showUnitsTable(List<UnitMeasurement> unitMeasurements) {
        String[] columns = {"ID", "Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        unitMeasurements.forEach(country -> {
            Object[] row = {country.getId(), country.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Units List", JOptionPane.PLAIN_MESSAGE);
    }
}
