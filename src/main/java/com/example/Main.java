package com.example;

import com.example.infrastructure.controller.PharmacyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame main = new JFrame();
        main.setTitle("Pharmacy");
        ImageIcon frameIcon = new ImageIcon("src/main/resources/images/health-health.png");
        main.setIconImage(frameIcon.getImage());

        ImageIcon gifIcon = new ImageIcon("src/main/resources/images/EHIK.gif");


        JLabel gifLabel = new JLabel(gifIcon);

        main.add(gifLabel);
        main.setVisible(true);

        main.pack();
        main.setLocationRelativeTo(null);

        JFrame welcome = new JFrame();
        welcome.setIconImage(frameIcon.getImage());
        welcome.setTitle("Pharmacy");
        welcome.setSize(800,500);
        welcome.setIconImage(frameIcon.getImage());
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setLocationRelativeTo(null);
        welcome.setResizable(false);
        welcome.setLayout(null);

        ImageIcon gifFarmacy = new ImageIcon(new ImageIcon("src/main/resources/images/health-health.png").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));

        JLabel image = new JLabel(gifFarmacy);
        image.setBounds(55,40,250,250);

        JLabel gifFarmacyLabel = new JLabel("Welcome to");
        gifFarmacyLabel.setBounds(390,100,400,60);

        JLabel ultimateFarmacyLabel = new JLabel("Ultimate Pharmacy!");
        ultimateFarmacyLabel.setBounds(305, 180, 500, 60);

        ultimateFarmacyLabel.setFont(new Font("Calibri", Font.BOLD, 50));
        gifFarmacyLabel.setFont(new Font("Calibri", Font.BOLD, 50));


        JButton continueButton = new JButton("Continue -->");
        continueButton.setBounds(235,335,350,60);
        continueButton.setFont(new Font("Calibri", Font.BOLD, 25));

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PharmacyController pharmacyController = new PharmacyController();
                pharmacyController.setIconImage(frameIcon.getImage());
                pharmacyController.setResizable(false);
                pharmacyController.setVisible(true);
                welcome.dispose();
            }
        });

        welcome.add(image);
        welcome.add(gifFarmacyLabel);
        welcome.add(ultimateFarmacyLabel);
        welcome.add(continueButton);

        Timer timer = new Timer(3000, e -> {
            welcome.setVisible(true);
            main.dispose();
        });

        timer.setRepeats(false);
        timer.start();
    }
}