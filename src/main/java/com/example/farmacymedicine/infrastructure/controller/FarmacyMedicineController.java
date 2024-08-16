package com.example.farmacymedicine.infrastructure.controller;

import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.farmacy.application.FindFarmaciesByIdUC;
import com.example.farmacy.application.FindFarmacyByNameUC;
import com.example.farmacy.application.ListAllFarmaciesUC;
import com.example.farmacy.domain.entity.Farmacy;
import com.example.farmacymedicine.application.*;
import com.example.farmacymedicine.domain.entity.FarmacyMedicine;
import com.example.laboratory.domain.entity.Laboratory;
import com.example.medicine.application.FindMedicineByIdUC;
import com.example.medicine.application.FindMedicineByNameUC;
import com.example.medicine.application.ListMedicinesUC;
import com.example.medicine.domain.entity.Medicine;
import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.unitmeasurement.domain.entity.UnitMeasurement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class FarmacyMedicineController {
    FindFarmacyMedicineByIdUC findFarmacyMedicineByIdUC;
    CreateFarmacyMedicineUC createFarmacyMedicineUC;
    UpdateFarmacyMedicineUC updateFarmacyMedicineUC;
    DeleteFarmacyMedicineUC deleteFarmacyMedicineUC;
    ListFarmacyMedicinesUC listFarmacyMedicineUC;
    ListAllFarmaciesUC listAllFarmaciesUC;
    ListMedicinesUC listMedicineUC;
    FindFarmacyByNameUC findFarmacyByNameUC;
    FindMedicineByNameUC findMedicineByNameUC;
    FindFarmaciesByIdUC findFarmaciesByIdUC;
    FindMedicineByIdUC findMedicineByIdUC;

    public FarmacyMedicineController(CreateFarmacyMedicineUC cfm, ListMedicinesUC lm, ListAllFarmaciesUC lf, FindMedicineByNameUC fmn, FindFarmacyByNameUC ffn) {
        this.createFarmacyMedicineUC = cfm;
        this.listMedicineUC = lm;
        this.listAllFarmaciesUC = lf;
        this.findMedicineByNameUC = fmn;
        this.findFarmacyByNameUC = ffn;
    }

    public FarmacyMedicineController(FindFarmacyMedicineByIdUC ffmi) {
        this.findFarmacyMedicineByIdUC = ffmi;
    }

    public FarmacyMedicineController(ListFarmacyMedicinesUC lfm) {
        this.listFarmacyMedicineUC = lfm;
    }

    public FarmacyMedicineController(UpdateFarmacyMedicineUC ufm, FindFarmacyMedicineByIdUC ffmi, ListAllFarmaciesUC lf, ListMedicinesUC lmm, FindFarmacyByNameUC ffn, FindMedicineByNameUC fmmn) {
        this.updateFarmacyMedicineUC = ufm;
        this.findFarmacyMedicineByIdUC = ffmi;
        this.listAllFarmaciesUC = lf;
        this.listMedicineUC = lmm;
        this.findFarmacyByNameUC = ffn;
        this.findMedicineByNameUC = fmmn;
    }

    public FarmacyMedicineController(DeleteFarmacyMedicineUC dfm, ListAllFarmaciesUC lf, ListMedicinesUC lm, FindFarmacyByNameUC ffn, FindMedicineByNameUC fmn) {
        this.deleteFarmacyMedicineUC = dfm;
        this.listAllFarmaciesUC = lf;
        this.listMedicineUC = lm;
        this.findFarmacyByNameUC = ffn;
        this.findMedicineByNameUC = fmn;
    }


    public void createFarmacyMedicine() {
        JFrame myFrame = new JFrame("Create Farmacy-Medicine");
        myFrame.setSize(500, 550);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setPreferredSize(new Dimension(380, 450));

        JLabel labelModeAdmin = new JLabel("Farmacy : ");

        java.util.List<Farmacy> farmacies =  listAllFarmaciesUC.execute();

        JComboBox<String> farmaciesBox = new JComboBox<>();
        for (Farmacy farmacy : farmacies  ) {
            farmaciesBox.addItem(farmacy.getName());
        }

        labelModeAdmin.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelModeAdmin.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelMedice = new JLabel("Medicine : ");
        java.util.List<Medicine> medicines =  listMedicineUC.execute();

        JComboBox<String> MedicineBox = new JComboBox<>();
        for (Medicine medicine : medicines  ) {
            MedicineBox.addItem(medicine.getName());
        }

        labelMedice.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelMedice.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelPrice = new JLabel(" Price : ");
        JTextField txtPrice = new JTextField();
        labelPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelPrice.setHorizontalAlignment(SwingConstants.CENTER);
        txtPrice.setFont(new Font("Calibri", Font.PLAIN, 15));

        JButton sendButton = new JButton("Enviar");

        panel.add(labelModeAdmin);
        panel.add(farmaciesBox);
        panel.add(labelMedice);
        panel.add(MedicineBox);
        panel.add(labelPrice);
        panel.add(txtPrice);
        panel.add(new JLabel());  // Placeholder for alignment
        panel.add(sendButton);

        JPanel containerPanel = new JPanel();
        containerPanel.add(panel);

        myFrame.add(containerPanel);

        myFrame.setVisible(true);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFarmacy = (String) farmaciesBox.getSelectedItem();
                Optional<Farmacy> farmacy = findFarmacyByNameUC.execute(nameFarmacy);
                String nameMedicine = (String) MedicineBox.getSelectedItem();
                Optional<Medicine> medicine = findMedicineByNameUC.execute(nameMedicine);

                try {
                FarmacyMedicine farmacyMedicine = new FarmacyMedicine();
                farmacyMedicine.setIdFarmacy(farmacy.get().getId());
                farmacyMedicine.setIdMedicineFartm(medicine.get().getId());
                farmacyMedicine.setPrice(Float.parseFloat(txtPrice.getText()));
                createFarmacyMedicineUC.execute(farmacyMedicine);
                myFrame.dispose();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Please enter a valid type of data!", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public void updateFarmacyMedicine() {
        JFrame myFrame = new JFrame("Update Farmacy-Medicine");
        myFrame.setSize(500, 550);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2, 10, 10));
        myPanel.setPreferredSize(new Dimension(380, 450));
        JButton nextButton = new JButton("Next ->");

        JLabel labelFarmacy = new JLabel("Farmacy : ");

        java.util.List<Farmacy> farmacies =  listAllFarmaciesUC.execute();

        JComboBox<String> farmaciesBox = new JComboBox<>();
        for (Farmacy farmacy : farmacies  ) {
            farmaciesBox.addItem(farmacy.getName());
        }

        labelFarmacy.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelFarmacy.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelMedice = new JLabel("Medicine : ");

        java.util.List<Medicine> medicines =  listMedicineUC.execute();

        JComboBox<String> MedicineBox = new JComboBox<>();
        for (Medicine medicine : medicines  ) {
            MedicineBox.addItem(medicine.getName());
        }

        labelMedice.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelMedice.setHorizontalAlignment(SwingConstants.CENTER);

        myPanel.add(labelFarmacy);
        myPanel.add(farmaciesBox);
        myPanel.add(labelMedice);
        myPanel.add(MedicineBox);
        myPanel.add(nextButton);
        myFrame.add(myPanel);

        myPanel.setVisible(true);

        myFrame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(4, 2, 10, 10));
                panel.setPreferredSize(new Dimension(380, 450));

                String nameFarmacy = (String) farmaciesBox.getSelectedItem();
                Optional<Farmacy> farmacy = findFarmacyByNameUC.execute(nameFarmacy);
                String nameMedicine = (String) MedicineBox.getSelectedItem();
                Optional<Medicine> medicine = findMedicineByNameUC.execute(nameMedicine);
                myPanel.setVisible(false);

                farmaciesBox.setSelectedItem(farmacy.get().getName());
                farmaciesBox.setEnabled(false);
                MedicineBox.setSelectedItem(medicine.get().getName());
                MedicineBox.setEnabled(false);

                JLabel labelPrice = new JLabel(" Price : ");
                JTextField txtPrice = new JTextField();
                labelPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelPrice.setHorizontalAlignment(SwingConstants.CENTER);
                txtPrice.setFont(new Font("Calibri", Font.PLAIN, 15));

                Optional<FarmacyMedicine> farmacyMedicine = findFarmacyMedicineByIdUC.execute(farmacy.get().getId(), medicine.get().getId());
                txtPrice.setText(String.valueOf(farmacyMedicine.get().getPrice()));

                JButton sendButton = new JButton("Enviar");

                panel.add(labelFarmacy);
                panel.add(farmaciesBox);
                panel.add(labelMedice);
                panel.add(MedicineBox);
                panel.add(labelPrice);
                panel.add(txtPrice);
                panel.add(new JLabel());  // Placeholder for alignment
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);

                myFrame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameFarmacy = (String) farmaciesBox.getSelectedItem();
                        Optional<Farmacy> farmacy1 = findFarmacyByNameUC.execute(nameFarmacy);
                        String nameMedicine = (String) MedicineBox.getSelectedItem();
                        Optional<Medicine> medicine1 = findMedicineByNameUC.execute(nameMedicine);

                        try {
                        farmacyMedicine.get().setIdFarmacy(farmacy1.get().getId());
                        farmacyMedicine.get().setIdMedicineFartm(medicine1.get().getId());
                        farmacyMedicine.get().setPrice(Float.parseFloat(txtPrice.getText()));
                        updateFarmacyMedicineUC.execute(farmacyMedicine.get());
                        myFrame.dispose();

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Please enter a valid type of data!", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });
            }
        });
    }

    public void deleteFarmacyMedicine(){
        JFrame myFrame = new JFrame("Delete Farmacy-Medicine");
        myFrame.setSize(500, 550);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2, 10, 10));
        myPanel.setPreferredSize(new Dimension(380, 450));
        JButton sendButton = new JButton("Delete ->");

        JLabel labelFarmacy = new JLabel("Farmacy : ");

        java.util.List<Farmacy> farmacies =  listAllFarmaciesUC.execute();

        JComboBox<String> farmaciesBox = new JComboBox<>();
        for (Farmacy farmacy : farmacies  ) {
            farmaciesBox.addItem(farmacy.getName());
        }

        labelFarmacy.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelFarmacy.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelMedice = new JLabel("Medicine : ");

        java.util.List<Medicine> medicines =  listMedicineUC.execute();

        JComboBox<String> MedicineBox = new JComboBox<>();
        for (Medicine medicine : medicines  ) {
            MedicineBox.addItem(medicine.getName());
        }

        labelMedice.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelMedice.setHorizontalAlignment(SwingConstants.CENTER);

        myPanel.add(labelFarmacy);
        myPanel.add(farmaciesBox);
        myPanel.add(labelMedice);
        myPanel.add(MedicineBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        myPanel.setVisible(true);


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFarmacy = (String) farmaciesBox.getSelectedItem();
                Optional<Farmacy> farmacy = findFarmacyByNameUC.execute(nameFarmacy);
                String nameMedicine = (String) MedicineBox.getSelectedItem();
                Optional<Medicine> medicine = findMedicineByNameUC.execute(nameMedicine);

                deleteFarmacyMedicineUC.execute(farmacy.get().getId(), medicine.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Farmacy-Medicine has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<FarmacyMedicine> FindFarmacyMedicineByID() {
        int idFarmacy = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Farmacy: "));
        int idMedicine = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Medicine: "));
        Optional<FarmacyMedicine> farmacyMedicine = findFarmacyMedicineByIdUC.execute(idFarmacy,idMedicine);

        if (farmacyMedicine.isPresent()) {
            JOptionPane.showMessageDialog(null, "Farmacy-Medicine founded:\nFarmacyID: " + farmacyMedicine.get().getIdFarmacy() + "\n MedicineID: " + farmacyMedicine.get().getIdMedicineFartm() +  "\nPrice: " + farmacyMedicine.get().getPrice(),
                    "Farmacy-Medicine's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Farmacy-Medicine not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return farmacyMedicine;
    }

    public java.util.List<FarmacyMedicine> ListFarmacyMedicines() {
        java.util.List<FarmacyMedicine> farmacyMedicines =  listFarmacyMedicineUC.execute();
        showFarmacyMedicinesTable(farmacyMedicines);
        return farmacyMedicines;
    }

    public static void showFarmacyMedicinesTable(List<FarmacyMedicine> farmacyMedicines) {
        String[] columns = {"FarmacyID", "MedicineID", "Price"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        farmacyMedicines.forEach(farmacyMedicine -> {
            Object[] row = {farmacyMedicine.getIdFarmacy(), farmacyMedicine.getIdMedicineFartm(), farmacyMedicine.getPrice()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Farmacy-Medicines List", JOptionPane.PLAIN_MESSAGE);
    }
}
