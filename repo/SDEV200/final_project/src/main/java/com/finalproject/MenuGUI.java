package com.finalproject;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGUI {
    public static void loadMenuGUI() {

        JPanel menuBarPanel = new JPanel();
        menuBarPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        menuBarPanel.setBounds(0, 0, 1280, 50);
        menuBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        JLabel appName = new JLabel("My Coffee App");
        appName.setFont(new Font("Ariel", Font.BOLD, 20));
        JButton menuButton = new JButton("Menu");
        JButton cartButton = new JButton("Cart");

        menuBarPanel.add(appName);
        menuBarPanel.add(menuButton);
        menuBarPanel.add(cartButton);


        JPanel sidePanel = new JPanel();
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sidePanel.setBounds(0, 49, 300, 750);

        JFrame menuFrame = new JFrame();
        menuFrame.setTitle("My Coffee App");
        menuFrame.setLayout(null);
        menuFrame.setSize(1280, 800);
        menuFrame.setResizable(false);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.add(menuBarPanel);
        menuFrame.add(sidePanel);
        menuFrame.setVisible(true);
    }
}
