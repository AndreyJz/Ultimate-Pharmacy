package com.example.modeadministration.infrastructure.controller;

import com.example.modeadministration.aplication.*;
import com.example.modeadministration.domain.entity.Modeadministration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class ModeAdministrationController {
    private ListModeadministrationsUC listModeAdministrationsUC;
    private FindModeadministrationByNameUC findModeAdministrationByNameUC;
    private FindModeadministrationByIdUC findModeAdministrationByIdUC;
    private UpdateModeadministrationUC updateModeAdministrationUC;
    private DeleteModeadministrationUC deleteModeAdministrationUC;
    private CreateModeadministrationUC createModeAdministrationUC;

    public ModeAdministrationController(CreateModeadministrationUC createModeAdministrationUC) {
        this.createModeAdministrationUC = createModeAdministrationUC;
    }

    public ModeAdministrationController(UpdateModeadministrationUC updateModeAdministrationUC, FindModeadministrationByNameUC findModeAdministrationByNameUC, ListModeadministrationsUC listModeAdministrationsUC) {
        this.updateModeAdministrationUC = updateModeAdministrationUC;
        this.findModeAdministrationByNameUC = findModeAdministrationByNameUC;
        this.listModeAdministrationsUC = listModeAdministrationsUC;
    }

    public ModeAdministrationController(DeleteModeadministrationUC deleteModeAdministrationUC, FindModeadministrationByNameUC findModeAdministrationByNameUC, ListModeadministrationsUC listModeAdministrationsUC) {
        this.deleteModeAdministrationUC = deleteModeAdministrationUC;
        this.findModeAdministrationByNameUC = findModeAdministrationByNameUC;
        this.listModeAdministrationsUC = listModeAdministrationsUC;
    }

    public ModeAdministrationController(FindModeadministrationByIdUC findModeAdministrationByIdUC) {
        this.findModeAdministrationByIdUC = findModeAdministrationByIdUC;
    }

    public ModeAdministrationController(ListModeadministrationsUC listModeAdministrationsUC) {
        this.listModeAdministrationsUC = listModeAdministrationsUC;
    }

    public void createModeAdministration() {
        JFrame myFrame = new JFrame("Create Mode Administration");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        // Crear componentes
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modeadministration modeAdministration = new Modeadministration();
                modeAdministration.setDescription(descriptionField.getText());
                createModeAdministrationUC.execute(modeAdministration);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Mode Administration has been added!", null, JOptionPane.PLAIN_MESSAGE);
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

    public void updateModeAdministration() {
        JFrame frame = new JFrame("Update Mode Administration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<Modeadministration> modeAdministrations = listModeAdministrationsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Modeadministration modeAdministration : modeAdministrations) {
            myComboBox.addItem(modeAdministration.getDescription());
        }

        JPanel myPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Go Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
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
                String description = (String) myComboBox.getSelectedItem();
                Optional<Modeadministration> modeAdministration = findModeAdministrationByNameUC.execute(description);
                myPanel.setVisible(false);

                JLabel labelId = new JLabel("ID : ");
                JTextField txtId = new JTextField();
                labelId.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelId.setHorizontalAlignment(SwingConstants.CENTER);
                txtId.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtId.setText(String.valueOf(modeAdministration.get().getId()));
                txtId.setEnabled(false);

                JLabel labelDescription = new JLabel("Description : ");
                JTextField txtDescription = new JTextField();
                labelDescription.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelDescription.setHorizontalAlignment(SwingConstants.CENTER);
                txtDescription.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtDescription.setText(modeAdministration.get().getDescription());

                JButton sendButton = new JButton("Done");

                panel.add(labelId);
                panel.add(txtId);
                panel.add(labelDescription);
                panel.add(txtDescription);
                panel.add(new JLabel());
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);
                containerPanel.setVisible(true);

                frame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Modeadministration updatedModeAdministration = new Modeadministration();
                        updatedModeAdministration.setId(Integer.parseInt(txtId.getText()));
                        updatedModeAdministration.setDescription(txtDescription.getText());
                        updateModeAdministrationUC.execute(updatedModeAdministration);
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "Mode Administration has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });
            }
        });
    }

    public void deleteModeAdministration() {
        JFrame myFrame = new JFrame("Delete Mode Administration");

        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton deleteButton = new JButton("Delete");

        List<Modeadministration> modeAdministrations = listModeAdministrationsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Modeadministration modeAdministration : modeAdministrations) {
            myComboBox.addItem(modeAdministration.getDescription());
        }

        myPanel.add(myComboBox);
        myPanel.add(deleteButton);
        myFrame.add(myPanel);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = (String) myComboBox.getSelectedItem();
                Optional<Modeadministration> modeAdministration = findModeAdministrationByNameUC.execute(description);
                deleteModeAdministrationUC.execute(modeAdministration.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Mode Administration has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Modeadministration> findModeAdministrationById() {
        String id = JOptionPane.showInputDialog(null, "Insert the ID of the Mode Administration you're looking for:");
        Optional<Modeadministration> modeAdministration = findModeAdministrationByIdUC.execute(Integer.parseInt(id));
        if (modeAdministration.isPresent()) {
            JOptionPane.showMessageDialog(null, "Mode Administration found:\nID: " + modeAdministration.get().getId() + "\nDescription: " + modeAdministration.get().getDescription(),
                    "Mode Administration Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Mode Administration not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return modeAdministration;
    }

    public List<Modeadministration> listModeAdministrations() {
        System.out.println("helloworld");
        List<Modeadministration> modeAdministrations = listModeAdministrationsUC.execute();
        showModeAdministrationsTable(modeAdministrations);
        return modeAdministrations;
    }

    public static void showModeAdministrationsTable(List<Modeadministration> modeAdministrations) {
        String[] columns = {"ID", "Description"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        modeAdministrations.forEach(modeAdministration -> {
            Object[] row = {modeAdministration.getId(), modeAdministration.getDescription()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Mode Administrations List", JOptionPane.PLAIN_MESSAGE);
    }
}

