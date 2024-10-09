package com.finalproject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Item;
import model.Menu;

public class GUI {
    final static String COFFEE = "Coffee";
    final static String TEA = "Tea";
    final static String FOOD = "Food & Dessert";

    public static JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("My Coffee App");
        frame.setLayout(null);
        frame.setSize(1280, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public static void loadMenuGUI(JFrame frame) {
        // clearFrame(frame);
        loadHeader(frame);
        
        JPanel sidePanel = new JPanel();
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sidePanel.setBounds(0, 49, 300, 750);
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 20));

        JPanel itemPanel = new JPanel();
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        itemPanel.setBounds(299, 49, 980, 750);
        itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 50));

        getMenuItem(COFFEE, itemPanel);

        JButton coffeeBtn = new JButton(COFFEE);
        coffeeBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        coffeeBtn.addActionListener(e -> {
            getMenuItem(COFFEE, itemPanel);
        });

        JButton teaBtn = new JButton(TEA);
        teaBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        teaBtn.addActionListener(e -> {
            getMenuItem(TEA, itemPanel);
        });

        JButton foodBtn = new JButton(FOOD);
        foodBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        foodBtn.addActionListener(e -> {
            getMenuItem(FOOD, itemPanel);
        });

        sidePanel.add(coffeeBtn);
        sidePanel.add(teaBtn);
        sidePanel.add(foodBtn);

        frame.add(itemPanel);
        frame.add(sidePanel);
    }

    public static void loadHeader(JFrame frame) {
        JPanel headerPanel = new JPanel();
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        headerPanel.setBounds(0, 0, 1280, 50);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        JLabel appName = new JLabel("My Coffee App");
        appName.setFont(new Font("Ariel", Font.BOLD, 24));
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(e -> {
            System.out.println("Page under construction!");
        });

        JButton cartButton = new JButton("Cart");
        cartButton.addActionListener(e -> {
            System.out.println("Page under construction!");
        });

        headerPanel.add(appName);
        headerPanel.add(menuButton);
        headerPanel.add(cartButton);
        frame.add(headerPanel);
    }

    public static void getMenuItem(String name, JPanel panel) {
        panel.removeAll();
        panel.setVisible(false);
        Menu coffeeMenu = HandleData.getMenu(name);
        for (Item item : coffeeMenu.getItems()) {
            
            // Get image and resize
            ImageIcon icon = new ImageIcon(item.getImg());
            Image img = icon.getImage();
            Image newImage = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);

            // Generate item in menu
            JButton itemBtn = new JButton(item.getName());
            itemBtn.setIcon(icon);
            itemBtn.setHorizontalTextPosition(JButton.TOP);
            itemBtn.setVerticalTextPosition(JButton.BOTTOM);
            itemBtn.setPreferredSize(new Dimension(200,250));
            panel.add(itemBtn);
        }
        panel.setVisible(true);
    }

    public static void clearFrame(JFrame frame) {
        frame.removeAll();
    }
}
