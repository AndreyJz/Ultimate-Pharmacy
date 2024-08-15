package com.example.laboratory.infrastructure.controller;

import com.example.city.aplication.FindCitiesUC;
import com.example.city.aplication.FindCityByIdUC;
import com.example.city.aplication.FindCityByNameUC;
import com.example.city.domain.entity.City;
import com.example.laboratory.application.*;
import com.example.laboratory.domain.entity.Laboratory;
import com.example.region.aplication.FindRegionByNameUC;
import com.example.region.aplication.ListRegionsUC;
import com.example.region.domain.entity.Region;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class LaboratoryController {
    private FindLaboratoriesUC findLaboratoriesUC;
    private FindLaboratoryByNameUC findLaboratoryByNameUC;
    private FindCityByNameUC findCityByNameUC;
    private FindCitiesUC findCitiesUC;
    private FindCityByIdUC findCityByIdUC;
    private FindLaboratoryByIdUC findCityByIdDC;
    private CreateLaboratoryUC createLaboratoryUC;
    private UpdateLaboratoryUC updateLaboratoryUC;
    private DeleteLaboratoryUC deleteLaboratoryUC;
    private String nameCity;
    private String idCity;

    public LaboratoryController(CreateLaboratoryUC createLaboratoryUC, FindCitiesUC findCitiesUC, FindCityByNameUC findCityByNameUC) {
        this.createLaboratoryUC = createLaboratoryUC;
        this.findCitiesUC = findCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
    }

    public LaboratoryController(FindLaboratoryByIdUC findLaboratoryByIdUC) {
        this.findCityByIdDC = findLaboratoryByIdUC;
    }

    public LaboratoryController(FindLaboratoriesUC findLaboratoriesUC) {
        this.findLaboratoriesUC = findLaboratoriesUC;
    }

    public LaboratoryController(UpdateLaboratoryUC updateLaboratoryUC, FindLaboratoriesUC findLaboratoriesUC, FindLaboratoryByNameUC findLaboratoryByNameUC, FindCitiesUC findCitiesUC, FindCityByNameUC findCityByNameUC) {
        this.updateLaboratoryUC = updateLaboratoryUC;
        this.findLaboratoriesUC = findLaboratoriesUC;
        this.findLaboratoryByNameUC = findLaboratoryByNameUC;
        this.findCitiesUC = findCitiesUC;
        this.findCityByNameUC = findCityByNameUC;
    }

    public LaboratoryController(DeleteLaboratoryUC dcuc, FindLaboratoriesUC fcsuc, FindLaboratoryByNameUC fcnuc) {
        this.deleteLaboratoryUC = dcuc;
        this.findLaboratoriesUC = fcsuc;
        this.findLaboratoryByNameUC = fcnuc;
    }

    public void createLaboratory() {
        JFrame myFrame = new JFrame("Create Laboratory");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        List<City> cities =  findCitiesUC.execute();

        JComboBox<String> regionField = new JComboBox<>();
        for (City city : cities) {
            regionField.addItem(city.getName());
        }

        JLabel imageLabel = new JLabel("name");
        JTextField nameField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Laboratory laboratory = new Laboratory();
                String nameCity = (String) regionField.getSelectedItem();
                Optional<City> city = findCityByNameUC.execute(nameCity);
                laboratory.setName(nameField.getText());
                laboratory.setCodeCityReg(city.get().getId());
                createLaboratoryUC.execute(laboratory);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Laboratory has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(nameField);
        panel.add(regionField);
        panel.add(sendButton);

        myFrame.add(panel);

        myFrame.setVisible(true);
    }

    public void updateLaboratory() {
        JFrame frame = new JFrame("Update Laboratory");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<Laboratory> laboratories =  findLaboratoriesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Laboratory laboratory : laboratories) {
            myComboBox.addItem(laboratory.getName());
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
                String nameLaboratory = (String) myComboBox.getSelectedItem();
                Optional<Laboratory> laboratory = findLaboratoryByNameUC.execute(nameLaboratory);
                myPanel.setVisible(false);

                JLabel labelCode = new JLabel("ID : ");
                JTextField txtCode = new JTextField();
                labelCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelCode.setHorizontalAlignment(SwingConstants.CENTER);
                txtCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtCode.setText(String.valueOf(laboratory.get().getId()));
                txtCode.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(laboratory.get().getName());

                JLabel labelRegion = new JLabel("City : ");
                JComboBox regionField = new JComboBox<>();

                List<City> cities = findCitiesUC.execute();
                cities.forEach(c -> regionField.addItem(c.getName()));
                regionField.setSelectedItem(laboratory.get().getCodeCityReg());

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
                        String nameCity = regionField.getSelectedItem().toString();
                        Optional<City> city = findCityByNameUC.execute(nameCity);

                        Laboratory laboratory = new Laboratory();
                        laboratory.setId(Integer.parseInt(txtCode.getText()));
                        laboratory.setCodeCityReg(city.get().getId());
                        laboratory.setName(txtName.getText());
                        updateLaboratoryUC.execute(laboratory);
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "Laboratory has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });

            }
        });
    }

    public void deleteLaboratory(){
        JFrame myFrame = new JFrame("Delete Laboratory");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<Laboratory> laboratories =  findLaboratoriesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Laboratory laboratory : laboratories) {
            myComboBox.addItem(laboratory.getName());
        }

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameLaboratory = (String) myComboBox.getSelectedItem();
                Optional<Laboratory> laboratory = findLaboratoryByNameUC.execute(nameLaboratory);
                deleteLaboratoryUC.execute(laboratory.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Laboratory has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Laboratory> FindLaboratoryByID() {
        int idLaboratory = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert The Code of The Laboratory you're looking for: "));
        Optional<Laboratory> laboratory = findCityByIdDC.execute(idLaboratory);
        if (laboratory.isPresent()) {
            JOptionPane.showMessageDialog(null, "Laboratory founded:\nID: " + laboratory.get().getId() + "\nNombre: " + laboratory.get().getName() + "\nCityRegion: " + laboratory.get().getCodeCityReg(),
                    "Laboratory's info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Laboratory not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return laboratory;
    }

    public List<Laboratory> ListLaboratories() {
        List<Laboratory> laboratories =  findLaboratoriesUC.execute();
        showLaboratoriesTable(laboratories);
        return laboratories;
    }

    public static void showLaboratoriesTable(List<Laboratory> cities) {
        String[] columns = {"Code", "Name", "CityRegion"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        cities.forEach(region -> {
            Object[] row = {region.getId(), region.getName(), region.getCodeCityReg()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Laboratory List", JOptionPane.PLAIN_MESSAGE);
    }
}
