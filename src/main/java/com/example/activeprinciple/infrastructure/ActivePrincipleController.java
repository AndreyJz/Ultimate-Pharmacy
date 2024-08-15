package com.example.activeprinciple.infrastructure;

import com.example.activeprinciple.aplication.*;
import com.example.activeprinciple.domain.entity.ActivePrinciple;
import com.example.unitmeasurement.domain.entity.UnitMeasurement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class ActivePrincipleController {
    private CreateActivePrincipleUC createActivePrincipleUC;
    private UpdateActivePrincipleUC updateActivePrincipleUC;
    private FindActivePrincipleByIdUC findActivePrincipleByIdUC;
    private FindActivePrinciplesUC findActivePrinciplesUC;
    private DeleteActivePrincipleUC deleteActivePrincipleUC;
    private FindActivePrincipleByNameUC findActivePrincipleByNameUC;

    public ActivePrincipleController(CreateActivePrincipleUC createActivePrincipleUC) {
        this.createActivePrincipleUC = createActivePrincipleUC;
    }

    public ActivePrincipleController(FindActivePrincipleByIdUC findActiveIngredientByIdUC) {
        this.findActivePrincipleByIdUC = findActiveIngredientByIdUC;
    }

    public ActivePrincipleController(FindActivePrinciplesUC findActivePrinciplesUC) {
        this.findActivePrinciplesUC = findActivePrinciplesUC;
    }  

    public ActivePrincipleController(UpdateActivePrincipleUC updateActivePrincipleUC) {
        this.updateActivePrincipleUC = updateActivePrincipleUC;
    }

    public ActivePrincipleController(UpdateActivePrincipleUC ucuc, FindActivePrinciplesUC fcsuc, FindActivePrincipleByNameUC fciduc) {
        this.updateActivePrincipleUC = ucuc;
        this.findActivePrinciplesUC = fcsuc;
        this.findActivePrincipleByNameUC = fciduc;
    }

    public ActivePrincipleController(DeleteActivePrincipleUC deleteActivePrincipleUC) {
        this.deleteActivePrincipleUC = deleteActivePrincipleUC;
    }

    public ActivePrincipleController(DeleteActivePrincipleUC dcuc, FindActivePrinciplesUC fcsuc, FindActivePrincipleByNameUC fciduc) {
        this.deleteActivePrincipleUC = dcuc;
        this.findActivePrinciplesUC = fcsuc;
        this.findActivePrincipleByNameUC = fciduc;
    }

    public ActivePrincipleController(FindActivePrincipleByNameUC findActivePrincipleByNameUC) {
        this.findActivePrincipleByNameUC = findActivePrincipleByNameUC;
    }

    public void CreateActivePrinciple() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JLabel descriptionLabel = new JLabel("Name:");
        JTextField descriptionField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivePrinciple activePrinciple = new ActivePrinciple();
                activePrinciple.setName(descriptionField.getText());
                createActivePrincipleUC.execute(activePrinciple);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Active Principle has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.add(descriptionLabel);
        panel.add(descriptionField);
        panel.add(sendButton);

        myFrame.add(panel);

        myFrame.setVisible(true);
    }

    public void UpdateActivePrinciple() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();

        List<ActivePrinciple> activePrinciples =  findActivePrinciplesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (ActivePrinciple activePrinciple : activePrinciples) {
            myComboBox.addItem(activePrinciple.getName());
        }

        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Go Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        myPanel.add(myComboBox);
        myPanel.add(nextButton);
        myPanel.add(backButton);
        myFrame.add(myPanel);

        myPanel.setVisible(true);
        myFrame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameActivePrinciple = (String) myComboBox.getSelectedItem();
                Optional<ActivePrinciple> activePrinciple = findActivePrincipleByNameUC.execute(nameActivePrinciple);
                myPanel.setVisible(false);

                JLabel labelCode = new JLabel("ID : ");
                JTextField txtCode = new JTextField();
                labelCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelCode.setHorizontalAlignment(SwingConstants.CENTER);
                txtCode.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtCode.setText(String.valueOf(activePrinciple.get().getId()));
                txtCode.setEnabled(false);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(activePrinciple.get().getName());

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

                myFrame.add(containerPanel);

                sendButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ActivePrinciple activePrinciple1 = new ActivePrinciple();
                        activePrinciple1.setId(Integer.parseInt(txtCode.getText()));
                        activePrinciple1.setName(txtName.getText());
                        updateActivePrincipleUC.execute(activePrinciple1);
                        myFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Active Principle has been updated!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });

            }
        });

        myFrame.setVisible(true);
    }

    public void DeleteActivePrinciple(){
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<ActivePrinciple> activePrinciples =  findActivePrinciplesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (ActivePrinciple activePrinciple : activePrinciples) {
            myComboBox.addItem(activePrinciple.getName());
        }
        
        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameActivePrinciple = (String) myComboBox.getSelectedItem();
                Optional<ActivePrinciple> activePrinciple = findActivePrincipleByNameUC.execute(nameActivePrinciple);
                deleteActivePrincipleUC.execute(activePrinciple.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Active Principle has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<ActivePrinciple> FindActivePrincipleByID() {
        int idOfActivePrinciple = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Active Principle: "));
        Optional<ActivePrinciple> activeIngredient = findActivePrincipleByIdUC.execute(idOfActivePrinciple);
        if (activeIngredient.isPresent()) {
            JOptionPane.showMessageDialog(null, "Active Principle founded:\nID: " + activeIngredient.get().getId() + "\nName: " + activeIngredient.get().getName(),
                    "Active Principle's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Active Principle not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return activeIngredient;
    }

    public List<ActivePrinciple> ListActiveIngredients() {
        List<ActivePrinciple> activePrinciples =  findActivePrinciplesUC.execute();
        showActiveIngredientsTable(activePrinciples);
        return activePrinciples;
    }

    public static void showActiveIngredientsTable(List<ActivePrinciple> activePrinciples) {
        String[] columns = {"ID", "Active Principle"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        activePrinciples.forEach(activeIngredient -> {
            Object[] row = {activeIngredient.getId(), activeIngredient.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Active Principle List", JOptionPane.PLAIN_MESSAGE);
    }
}
