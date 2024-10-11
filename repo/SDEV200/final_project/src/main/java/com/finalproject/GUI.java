package com.finalproject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import model.Item;

public class GUI {

    final static String MENU = "menu";
    final static String CART = "cart";
    final static String ITEM = "item";
    final static String COFFEE = "coffee";
    final static String TEA = "tea";
    final static String FOOD = "food";

    static double addPrice = 0.0;

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
        loadHeader(frame);
        
        JPanel sidePanel = new JPanel();
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sidePanel.setBounds(0, 59, 300, 740);
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 20));

        JPanel itemPanel = new JPanel();
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        itemPanel.setBounds(299, 49, 980, 750);
        itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 50));

        loadMenuItem(COFFEE, itemPanel);

        JButton coffeeBtn = new JButton("Coffee");
        coffeeBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        coffeeBtn.setPreferredSize(new Dimension(200,50));
        coffeeBtn.setFocusable(false);
        coffeeBtn.addActionListener(e -> {
            loadMenuItem(COFFEE, itemPanel);
        });

        JButton teaBtn = new JButton("Tea");
        teaBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        teaBtn.setPreferredSize(new Dimension(200,50));
        teaBtn.setFocusable(false);
        teaBtn.addActionListener(e -> {
            loadMenuItem(TEA, itemPanel);
        });

        JButton foodBtn = new JButton("Food & Dessert");
        foodBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        foodBtn.setPreferredSize(new Dimension(200,50));
        foodBtn.setFocusable(false);
        foodBtn.addActionListener(e -> {
            loadMenuItem(FOOD, itemPanel);
        });

        sidePanel.add(coffeeBtn);
        sidePanel.add(teaBtn);
        sidePanel.add(foodBtn);

        frame.add(itemPanel);
        frame.add(sidePanel);
    }

    public static void loadCartGUI(JFrame frame) {
        loadHeader(frame);
    }

    public static void loadHeader(JFrame frame) {
        JPanel headerPanel = new JPanel();
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        headerPanel.setBounds(0, 0, 1280, 60);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        
        JLabel appName = new JLabel("My Coffee App");
        appName.setFont(new Font("Ariel", Font.BOLD, 24));

        JButton menuBtn = new JButton("Menu");
        menuBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        menuBtn.setPreferredSize(new Dimension(200,30));
        menuBtn.setFocusable(false);
        menuBtn.addActionListener(e -> {
            Controller.loadGUI(MENU);
        });

        JButton cartBtn = new JButton("Cart");
        cartBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        cartBtn.setPreferredSize(new Dimension(200,30));
        cartBtn.setFocusable(false);
        cartBtn.addActionListener(e -> {
            Controller.loadGUI(CART);
        });

        headerPanel.add(appName);
        headerPanel.add(menuBtn);
        headerPanel.add(cartBtn);
        frame.add(headerPanel);
    }

    public static void loadItemGUI(JFrame frame, Item item) {

        loadHeader(frame);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 100, 550, 400);
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(700, 130, 500, 400);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.black));
        bottomPanel.setBounds(100, 549, 1065, 200);

        JLabel itemName = new JLabel(item.getName());
        itemName.setFont(new Font("Arial", Font.BOLD, 28));

        Image img = new ImageIcon(item.getImg()).getImage();
        Image newImage = img.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(newImage));

        JTextArea itemDesc = new JTextArea(item.getDescribe());
        itemDesc.setEditable(false);
        itemDesc.setBackground(null);
        itemDesc.setFont(new Font("Arial", Font.PLAIN, 18));
        itemDesc.setSize(new Dimension(100,50));

        JLabel descTitle = new JLabel("Description");
        descTitle.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel itemPrice = new JLabel("$" + String.valueOf(item.getPrice()));
        itemPrice.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel sizeOptLabel = new JLabel("Size Options");
        sizeOptLabel.setFont(new Font("Arial", Font.BOLD, 20));
        sizeOptLabel.setAlignmentY(Component.TOP_ALIGNMENT);

        JButton addBtn = new JButton("Add to cart");
        addBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        addBtn.setPreferredSize(new Dimension(200,50));
        addBtn.setFocusable(false);
        addBtn.addActionListener(e -> {
            Controller.addToCart(item.getName(), item.getCategory(), addPrice);
            addPrice = 0.0;
        });

        leftPanel.add(imgLabel);
        rightPanel.add(itemName);
        rightPanel.add(itemPrice);

        if (item.getCategory().equals(COFFEE) || item.getCategory().equals(TEA)) {
            JRadioButton smallBtn = new JRadioButton("Small +$0.00", true);
            smallBtn.setFont(new Font("Arial", Font.PLAIN, 20));
            smallBtn.addActionListener(e -> {
                addPrice = 0.0;
            });

            JRadioButton mediumBtn = new JRadioButton("Medium +$2.00");
            mediumBtn.setFont(new Font("Arial", Font.PLAIN, 20));
            mediumBtn.addActionListener(e -> {
                addPrice = 2.0;
            });

            JRadioButton largeBtn = new JRadioButton("Large +$3.00");
            largeBtn.setFont(new Font("Arial", Font.PLAIN, 20));
            largeBtn.addActionListener(e -> {
                addPrice = 3.0;
            });
            
            ButtonGroup btnGr = new ButtonGroup();
            btnGr.add(smallBtn);
            btnGr.add(largeBtn);
            btnGr.add(mediumBtn);

            rightPanel.add(sizeOptLabel);
            rightPanel.add(smallBtn);
            rightPanel.add(mediumBtn);
            rightPanel.add(largeBtn);
        }
        
        rightPanel.add(addBtn);
        bottomPanel.add(descTitle);
        bottomPanel.add(itemDesc);
        
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.add(bottomPanel);
    }

    public static void loadMenuItem(String menuName, JPanel panel) {
        panel.removeAll();
        panel.setVisible(false);
        Item[] items = HandleData.getItemsOfCategory(menuName);
        for (Item item : items) {
            
            // Get image and resize
            ImageIcon icon = new ImageIcon(item.getImg());
            Image img = icon.getImage();
            Image newImage = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);

            // Generate item in menu
            JButton itemBtn = new JButton(item.getName() + " - $" + item.getPrice());
            itemBtn.setIcon(icon);
            itemBtn.setFocusable(false);
            itemBtn.setHorizontalTextPosition(JButton.CENTER);
            itemBtn.setVerticalTextPosition(JButton.BOTTOM);
            itemBtn.setPreferredSize(new Dimension(200,235));
            itemBtn.addActionListener(e -> {
                Controller.loadItemGUI(item);
            });
            panel.add(itemBtn);
        }
        panel.setVisible(true);
    }
}
