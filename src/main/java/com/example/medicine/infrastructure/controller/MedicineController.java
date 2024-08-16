package com.example.medicine.infrastructure.controller;

import com.example.activeprinciple.aplication.FindActivePrincipleByIdUC;
import com.example.activeprinciple.aplication.FindActivePrincipleByNameUC;
import com.example.activeprinciple.aplication.FindActivePrinciplesUC;
import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.city.aplication.FindCitiesUC;
import com.example.city.aplication.FindCityByIdUC;
import com.example.city.aplication.FindCityByNameUC;
import com.example.city.domain.entity.City;
import com.example.laboratory.application.FindLaboratoriesUC;
import com.example.laboratory.application.FindLaboratoryByIdUC;
import com.example.laboratory.application.FindLaboratoryByNameUC;
import com.example.laboratory.domain.entity.Laboratory;
import com.example.medicine.application.*;
import com.example.modeadministration.aplication.FindModeadministrationByIdUC;
import com.example.modeadministration.aplication.FindModeadministrationByNameUC;
import com.example.modeadministration.aplication.ListModeadministrationsUC;
import com.example.unitmeasurement.application.*;
import com.example.medicine.domain.entity.Medicine;
import com.example.modeadministration.domain.entity.Modeadministration;
import com.example.unitmeasurement.domain.entity.UnitMeasurement;
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

public class MedicineController {
    private ListMedicinesUC listMedicinesUC;
    private FindMedicineByNameUC findMedicineByNameUC;
    private FindUnitMeasurementByNameUC findUnitMeasurementByNameUC;
    private ListUnitMeasurementsUC listUnitMeasurementsUC;
    private FindUnitMeasurementByIdUC findUnitMeasurementByIdUC;
    private FindActivePrincipleByNameUC findActivePrincipleByNameUC;
    private FindActivePrinciplesUC findActivePrinciplesUC;
    private FindActivePrincipleByIdUC findActivePrincipleByIdUC;
    private FindModeadministrationByNameUC findModeadministrationByNameUC;
    private ListModeadministrationsUC listModeadministrationsUC;
    private FindModeadministrationByIdUC findModeadministrationByIdUC;
    private FindLaboratoryByNameUC findLaboratoryByNameUC;
    private FindLaboratoriesUC findLaboratoriesUC;
    private FindLaboratoryByIdUC findLaboratoryByIdUC;
    private FindMedicineByIdUC findCustomersByIdUC;
    private CreateMedicineUC createMedicineUC;
    private UpdateMedicineUC updateMedicineUC;
    private DeleteMedicineUC deleteMedicineUC;


    public MedicineController(FindMedicineByIdUC findCustomersByIdUC) {
        this.findCustomersByIdUC = findCustomersByIdUC;
    }

    public MedicineController(ListMedicinesUC listAllCustomersUC) {
        this.listMedicinesUC = listAllCustomersUC;
    }

    public MedicineController(DeleteMedicineUC dcuc, ListMedicinesUC fcsuc, FindMedicineByNameUC fcnuc) {
        this.deleteMedicineUC = dcuc;
        this.listMedicinesUC = fcsuc;
        this.findMedicineByNameUC = fcnuc;
    }


    public MedicineController(CreateMedicineUC mc, ListModeadministrationsUC lm, ListUnitMeasurementsUC lu, FindActivePrinciplesUC fp, FindLaboratoriesUC fl, FindModeadministrationByNameUC fmn, FindUnitMeasurementByNameUC fumn, FindActivePrincipleByNameUC fapn, FindLaboratoryByNameUC fln) {
        this.createMedicineUC = mc;
        this.listModeadministrationsUC = lm;
        this.listUnitMeasurementsUC = lu;
        this.findActivePrinciplesUC = fp;
        this.findLaboratoriesUC = fl;
        this.findModeadministrationByNameUC = fmn;
        this.findUnitMeasurementByNameUC = fumn;
        this.findActivePrincipleByNameUC = fapn;
        this.findLaboratoryByNameUC = fln;
    }

    public MedicineController(UpdateMedicineUC um, ListMedicinesUC lmm, ListModeadministrationsUC lm, ListUnitMeasurementsUC lu, FindActivePrinciplesUC fp, FindLaboratoriesUC fl, FindMedicineByNameUC fmmn, FindModeadministrationByNameUC fmn, FindUnitMeasurementByNameUC fumn, FindActivePrincipleByNameUC fapn, FindLaboratoryByNameUC fln, FindModeadministrationByIdUC fmi, FindUnitMeasurementByIdUC fumi, FindActivePrincipleByIdUC fapi, FindLaboratoryByIdUC fli) {
        this.updateMedicineUC = um;
        this.listMedicinesUC = lmm;
        this.listModeadministrationsUC = lm;
        this.listUnitMeasurementsUC = lu;
        this.findActivePrinciplesUC = fp;
        this.findLaboratoriesUC = fl;
        this.findMedicineByNameUC = fmmn;
        this.findModeadministrationByNameUC = fmn;
        this.findUnitMeasurementByNameUC = fumn;
        this.findActivePrincipleByNameUC = fapn;
        this.findLaboratoryByNameUC = fln;
        this.findModeadministrationByIdUC = fmi;
        this.findUnitMeasurementByIdUC = fumi;
        this.findActivePrincipleByIdUC = fapi;
        this.findLaboratoryByIdUC = fli;
    }

    public void createMedicine() {
        JFrame myFrame = new JFrame("Create Medicine");
        myFrame.setSize(500, 550);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));
        panel.setPreferredSize(new Dimension(380, 450));

        JLabel labelProceedings = new JLabel("Proceedings : ");
        JTextField txtProceedings = new JTextField();
        labelProceedings.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelProceedings.setHorizontalAlignment(SwingConstants.CENTER);
        txtProceedings.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelName = new JLabel("Name : ");
        JTextField txtName = new JTextField();
        labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelHealthRegister = new JLabel("Health Register : ");
        JTextField txtHealthRegister = new JTextField();
        labelHealthRegister.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelHealthRegister.setHorizontalAlignment(SwingConstants.CENTER);
        txtHealthRegister.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelDescripcion = new JLabel("Descripcion : ");
        JTextField txtDescripcion = new JTextField();
        labelDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
        txtDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelDescripcionShort = new JLabel("Descripcion Short : ");
        JTextField txtDescripcionShort = new JTextField();
        labelDescripcionShort.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelDescripcionShort.setHorizontalAlignment(SwingConstants.CENTER);
        txtDescripcionShort.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelModeAdmin = new JLabel("ModeAdmin : ");

        List<Modeadministration> modeadministrations =  listModeadministrationsUC.execute();

        JComboBox<String> modeAdminBox = new JComboBox<>();
        for (Modeadministration modeadministration : modeadministrations  ) {
            modeAdminBox.addItem(modeadministration.getDescription());
        }

        labelModeAdmin.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelModeAdmin.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelap = new JLabel("ActivePrinciple : ");

        List<ActivePrinciple> activePrinciples =  findActivePrinciplesUC.execute();

        JComboBox<String> apBox = new JComboBox<>();
        for (ActivePrinciple activePrinciple : activePrinciples  ) {
            apBox.addItem(activePrinciple.getName());
        }

        labelap.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelap.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelum = new JLabel("Unit Measurement : ");

        List<UnitMeasurement> unitMeasurements =  listUnitMeasurementsUC.execute();

        JComboBox<String> umBox = new JComboBox<>();
        for (UnitMeasurement unitMeasurement : unitMeasurements  ) {
            umBox.addItem(unitMeasurement.getName());
        }

        labelum.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelum.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelLab = new JLabel("Laboratory : ");

        List<Laboratory> laboratories =  findLaboratoriesUC.execute();

        JComboBox<String> LabBox = new JComboBox<>();
        for (Laboratory laboratory : laboratories  ) {
            LabBox.addItem(laboratory.getName());
        }

        labelLab.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelLab.setHorizontalAlignment(SwingConstants.CENTER);

        JButton sendButton = new JButton("Enviar");

        panel.add(labelProceedings);
        panel.add(txtProceedings);
        panel.add(labelName);
        panel.add(txtName);
        panel.add(labelHealthRegister);
        panel.add(txtHealthRegister);
        panel.add(labelDescripcion);
        panel.add(txtDescripcion);
        panel.add(labelDescripcionShort);
        panel.add(txtDescripcionShort);
        panel.add(labelModeAdmin);
        panel.add(modeAdminBox);
        panel.add(labelap);
        panel.add(apBox);
        panel.add(labelum);
        panel.add(umBox);
        panel.add(labelLab);
        panel.add(LabBox);
        panel.add(new JLabel());  // Placeholder for alignment
        panel.add(sendButton);

        JPanel containerPanel = new JPanel();
        containerPanel.add(panel);

        myFrame.add(containerPanel);

        myFrame.setVisible(true);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameModeAdmin = (String) modeAdminBox.getSelectedItem();
                Optional<Modeadministration> modeadministration = findModeadministrationByNameUC.execute(nameModeAdmin);
                String nameAP = (String) apBox.getSelectedItem();
                Optional<ActivePrinciple> activePrinciple = findActivePrincipleByNameUC.execute(nameAP);
                String nameUM = (String) umBox.getSelectedItem();
                Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByNameUC.execute(nameUM);
                String nameLab = (String) LabBox.getSelectedItem();
                Optional<Laboratory> laboratory = findLaboratoryByNameUC.execute(nameLab);

                Medicine medicine = new Medicine();
                medicine.setProceedings(txtProceedings.getText());
                medicine.setName(txtName.getText());
                medicine.setHealthRegister(txtHealthRegister.getText());
                medicine.setDescription(txtDescripcion.getText());
                medicine.setDescriptionShort(txtDescripcionShort.getText());
                medicine.setCodeModeAdmin(modeadministration.get().getId());
                medicine.setCodePa(activePrinciple.get().getId());
                medicine.setCodeUm(unitMeasurement.get().getId());
                medicine.setCodeLab(laboratory.get().getId());
                createMedicineUC.execute(medicine);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Medicine has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public void updateMedicine() {
        JFrame myFrame = new JFrame("Update Medicine");
        myFrame.setSize(500, 550);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton nextButton = new JButton("Next ->");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2, 10, 10));
        panel.setPreferredSize(new Dimension(380, 450));

        List<Medicine> customers =  listMedicinesUC.execute();

        JComboBox<String> customersBox = new JComboBox<>();
        for (Medicine customer : customers) {
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
                Optional<Medicine> customer = findMedicineByNameUC.execute(nameCustomer);
                myPanel.setVisible(false);

                JLabel labelID = new JLabel("ID : ");
                JTextField txtID = new JTextField();
                labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelID.setHorizontalAlignment(SwingConstants.CENTER);
                txtID.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtID.setText(String.valueOf(customer.get().getId()));

                JLabel labelProceedings = new JLabel("Proceedings : ");
                JTextField txtProceedings = new JTextField();
                labelProceedings.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelProceedings.setHorizontalAlignment(SwingConstants.CENTER);
                txtProceedings.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtProceedings.setText(String.valueOf(customer.get().getProceedings()));

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(String.valueOf(customer.get().getName()));

                JLabel labelHealthRegister = new JLabel("Health Register : ");
                JTextField txtHealthRegister = new JTextField();
                labelHealthRegister.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelHealthRegister.setHorizontalAlignment(SwingConstants.CENTER);
                txtHealthRegister.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtHealthRegister.setText(String.valueOf(customer.get().getHealthRegister()));

                JLabel labelDescripcion = new JLabel("Descripcion : ");
                JTextField txtDescripcion = new JTextField();
                labelDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
                txtDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtDescripcion.setText(String.valueOf(customer.get().getDescription()));

                JLabel labelDescripcionShort = new JLabel("Descripcion Short : ");
                JTextField txtDescripcionShort = new JTextField();
                labelDescripcionShort.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelDescripcionShort.setHorizontalAlignment(SwingConstants.CENTER);
                txtDescripcionShort.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtDescripcionShort.setText(String.valueOf(customer.get().getDescriptionShort()));

                JLabel labelModeAdmin = new JLabel("ModeAdmin : ");

                List<Modeadministration> modeadministrations =  listModeadministrationsUC.execute();

                JComboBox<String> modeAdminBox = new JComboBox<>();
                for (Modeadministration modeadministration : modeadministrations  ) {
                    modeAdminBox.addItem(modeadministration.getDescription());
                }

                labelModeAdmin.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelModeAdmin.setHorizontalAlignment(SwingConstants.CENTER);

                Optional<Modeadministration> modeadministration = findModeadministrationByIdUC.execute(customer.get().getCodeModeAdmin());
                modeAdminBox.setSelectedItem(modeadministration.get().getDescription());

                JLabel labelap = new JLabel("ActivePrinciple : ");

                List<ActivePrinciple> activePrinciples =  findActivePrinciplesUC.execute();

                JComboBox<String> apBox = new JComboBox<>();
                for (ActivePrinciple activePrinciple : activePrinciples  ) {
                    apBox.addItem(activePrinciple.getName());
                }

                labelap.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelap.setHorizontalAlignment(SwingConstants.CENTER);

                Optional<ActivePrinciple> activePrinciple = findActivePrincipleByIdUC.execute(customer.get().getCodePa());
                apBox.setSelectedItem(activePrinciple.get().getName());

                JLabel labelum = new JLabel("Unit Measurement : ");

                List<UnitMeasurement> unitMeasurements =  listUnitMeasurementsUC.execute();

                JComboBox<String> umBox = new JComboBox<>();
                for (UnitMeasurement unitMeasurement : unitMeasurements  ) {
                    umBox.addItem(unitMeasurement.getName());
                }

                labelum.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelum.setHorizontalAlignment(SwingConstants.CENTER);

                Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByIdUC.execute(customer.get().getCodeUm());
                umBox.setSelectedItem(unitMeasurement.get().getName());

                JLabel labelLab = new JLabel("Laboratory : ");

                List<Laboratory> laboratories =  findLaboratoriesUC.execute();

                JComboBox<String> LabBox = new JComboBox<>();
                for (Laboratory laboratory : laboratories  ) {
                    LabBox.addItem(laboratory.getName());
                }

                labelLab.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLab.setHorizontalAlignment(SwingConstants.CENTER);

                Optional<Laboratory> laboratory = findLaboratoryByIdUC.execute(customer.get().getCodeLab());
                LabBox.setSelectedItem(laboratory.get().getName());

                JButton sendButton = new JButton("Enviar");

                panel.add(labelID);
                panel.add(txtID);
                panel.add(labelProceedings);
                panel.add(txtProceedings);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(labelHealthRegister);
                panel.add(txtHealthRegister);
                panel.add(labelDescripcion);
                panel.add(txtDescripcion);
                panel.add(labelDescripcionShort);
                panel.add(txtDescripcionShort);
                panel.add(labelModeAdmin);
                panel.add(modeAdminBox);
                panel.add(labelap);
                panel.add(apBox);
                panel.add(labelum);
                panel.add(umBox);
                panel.add(labelLab);
                panel.add(LabBox);
                panel.add(new JLabel());  // Placeholder for alignment
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);

                myFrame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameModeAdmin = (String) modeAdminBox.getSelectedItem();
                        Optional<Modeadministration> modeadministration = findModeadministrationByNameUC.execute(nameModeAdmin);
                        String nameAP = (String) apBox.getSelectedItem();
                        Optional<ActivePrinciple> activePrinciple = findActivePrincipleByNameUC.execute(nameAP);
                        String nameUM = (String) umBox.getSelectedItem();
                        Optional<UnitMeasurement> unitMeasurement = findUnitMeasurementByNameUC.execute(nameUM);
                        String nameLab = (String) LabBox.getSelectedItem();
                        Optional<Laboratory> laboratory = findLaboratoryByNameUC.execute(nameLab);
                        Medicine medicine = new Medicine();
                        medicine.setId(Integer.parseInt(txtID.getText()));
                        medicine.setProceedings(txtProceedings.getText());
                        medicine.setName(txtName.getText());
                        medicine.setHealthRegister(txtHealthRegister.getText());
                        medicine.setDescription(txtDescripcion.getText());
                        medicine.setDescriptionShort(txtDescripcionShort.getText());
                        medicine.setCodeModeAdmin(modeadministration.get().getId());
                        medicine.setCodePa(activePrinciple.get().getId());
                        medicine.setCodeUm(unitMeasurement.get().getId());
                        medicine.setCodeLab(laboratory.get().getId());
                        updateMedicineUC.execute(medicine);
                        myFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Medicine has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });
            }
        });
    }

    public void deleteMedicine(){
        JFrame myFrame = new JFrame("Delete Medicine");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<Medicine> medicines =  listMedicinesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Medicine medicine : medicines) {
            myComboBox.addItem(medicine.getName());
        }

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameMedicine = (String) myComboBox.getSelectedItem();
                Optional<Medicine> customer = findMedicineByNameUC.execute(nameMedicine);
                deleteMedicineUC.execute(customer.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Medicine has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Medicine> FindMedicineByID() {
        int idMedicine = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Medicine of id: "));
        Optional<Medicine> customer = findCustomersByIdUC.execute(idMedicine);
        if (customer.isPresent()) {
            JOptionPane.showMessageDialog(null, "Medicine founded:\nID: " + customer.get().getId() + "\n Proccedings: " + customer.get().getProceedings() +  "\nNombre: " + customer.get().getName() + "\nDescription: " + customer.get().getDescription() + "\nDescription Short: " + customer.get().getDescriptionShort() + "\nHealthRegister: " + customer.get().getHealthRegister() + "\nModeAdmin: " + customer.get().getCodeModeAdmin() + "\nActive Principle : " + customer.get().getCodePa() + "\nUnit Measurement : " + customer.get().getCodeUm() + "\nLaboratory : " + customer.get().getCodeLab(),
                    "Medicine's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Medicine not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }

    public List<Medicine> ListMedicines() {
        List<Medicine> medicines =  listMedicinesUC.execute();
        showMedicinesTable(medicines);
        return medicines;
    }

    public static void showMedicinesTable(List<Medicine> medicines) {
        String[] columns = {"ID", "Proccedings", "Name", "Health Register", "Description", "Description Short", "ModeAdmin", "Unit Measurement", "Active Principle", "Laboratory"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        medicines.forEach(customer -> {
            Object[] row = {customer.getId(), customer.getProceedings(), customer.getName(), customer.getHealthRegister(), customer.getDescription(), customer.getDescriptionShort(), customer.getCodeModeAdmin(), customer.getCodePa(), customer.getCodeUm(), customer.getCodeLab()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Medicines List", JOptionPane.PLAIN_MESSAGE);
    }
}
