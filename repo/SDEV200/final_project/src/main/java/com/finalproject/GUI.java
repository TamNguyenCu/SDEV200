package com.finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Item;

public class GUI extends JFrame implements ActionListener {

    final static String MENU = "menu";
    final static String CART = "cart";
    final static String ITEM = "item";
    final static String CHECKOUT = "checkout";
    final static String COFFEE = "coffee";
    final static String TEA = "tea";
    final static String FOOD = "food";

    static double taxRate = 0.08;
    static double addPrice = 0.0;
    static double total = 0.0;

    // GUI constructor
    public GUI() {
        super("The Coffee Shop");
        final int WIDTH = 1280;
        final int HEIGHT = 800;
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(FilePath.iconImage()).getImage());
        header(this);
    }

    // create menu GUI
    public static void menuGUI(JFrame frame) {
        JPanel sidePanel = new JPanel();
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        sidePanel.setBounds(0, 59, 300, 740);
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 20));

        JPanel itemPanel = new JPanel();

        JScrollPane scroll = new JScrollPane(itemPanel);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);
        panel.setBounds(299, 60, 967, 703);

        menuItem(COFFEE, itemPanel);

        JButton coffeeBtn = new JButton("Coffee");
        coffeeBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        coffeeBtn.setPreferredSize(new Dimension(200, 50));
        coffeeBtn.setFocusable(false);
        coffeeBtn.addActionListener(e -> {
            menuItem(COFFEE, itemPanel);
        });

        JButton teaBtn = new JButton("Tea");
        teaBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        teaBtn.setPreferredSize(new Dimension(200, 50));
        teaBtn.setFocusable(false);
        teaBtn.addActionListener(e -> {
            menuItem(TEA, itemPanel);
        });

        JButton foodBtn = new JButton("Food & Dessert");
        foodBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        foodBtn.setPreferredSize(new Dimension(200, 50));
        foodBtn.setFocusable(false);
        foodBtn.addActionListener(e -> {
            menuItem(FOOD, itemPanel);
        });

        sidePanel.add(coffeeBtn);
        sidePanel.add(teaBtn);
        sidePanel.add(foodBtn);

        frame.add(panel);
        frame.add(sidePanel);
    }

    // create checkout GUI
    public static void checkoutGUI(JFrame frame, List<Item> items) {
        double saleTax = total * taxRate;

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50,10));
        infoPanel.setBounds(150, 200, 400, 400);

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        orderPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.black));
        orderPanel.setBounds(700, 200, 400, 200);
        
        Font bigFont = new Font("Arial", Font.BOLD, 20);
        JLabel name = new JLabel("*Name:");
        name.setFont(bigFont);
        JTextField nameField = new JTextField(20);

        JLabel email = new JLabel(" Email:");
        email.setFont(bigFont);
        JTextField emailField = new JTextField(20);

        JLabel subTotLabel = new JLabel("Subtotal: $" + total);
        subTotLabel.setFont(bigFont);

        JLabel saleTaxLabel = new JLabel("Tax: $" + String.format("%.2f", saleTax));
        saleTaxLabel.setFont(bigFont);

        JLabel totalLabel = new JLabel("Total: $" + (saleTax + total));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JButton orderBtn = new JButton("Place your order");
        orderBtn.setFont(bigFont);
        orderBtn.setFocusable(false);
        orderBtn.setSize(new Dimension(120, 30));
        orderBtn.setFont(new Font("Arial", Font.BOLD, 28));
        orderBtn.setForeground(Color.white);
        orderBtn.setBackground(Color.DARK_GRAY);
        if (nameField.getText().length() == 0) {
            orderBtn.setEnabled(false);
        }
        // even listener for name field
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkInput();
            }

            public void checkInput() {
                if (nameField.getText().length() > 0) {
                    orderBtn.setEnabled(true);
                } else {
                    orderBtn.setEnabled(false);
                }
            }
        });

        orderBtn.addActionListener(e -> {
            Controller.checkout();
        });


        infoPanel.add(name);
        infoPanel.add(nameField);
        infoPanel.add(email);
        infoPanel.add(emailField);
        infoPanel.add(orderBtn);

        orderPanel.add(subTotLabel);
        orderPanel.add(saleTaxLabel);
        orderPanel.add(totalLabel);

        frame.add(infoPanel);
        frame.add(orderPanel);
    }

    // create cart GUI
    public static void cartGUI(JFrame frame, List<Item> items) {
        total = 0.0;

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(items.size(), 4));

        JScrollPane scroll = new JScrollPane(itemPanel);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);
        panel.setBounds(100, 80, 1060, 550);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(100, 630, 1060, 100);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 350, 10));

        for (Item item : items) {
            // Get image and resize
            Image img = new ImageIcon(item.getImg()).getImage();
            Image newImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel itemImage = new JLabel(new ImageIcon(newImage));
            itemImage.setAlignmentX(Component.LEFT_ALIGNMENT);
            JLabel itemLabel = new JLabel(item.getName());
            JLabel itemPrice = new JLabel("$" + item.getPrice());
            Image delIcon = new ImageIcon(FilePath.iconRemove()).getImage();
            Image newDelImage = delIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JButton delBtn = new JButton();
            delBtn.setFocusable(false);
            delBtn.setBorderPainted(false);
            delBtn.setContentAreaFilled(false);
            delBtn.setIcon(new ImageIcon(newDelImage));
            delBtn.addActionListener(e -> {
                items.remove(item);
                total -= item.getPrice();
                Controller.loadCartGUI();
            });
            total += item.getPrice();

            itemPanel.add(itemImage);
            itemPanel.add(itemLabel);
            itemPanel.add(itemPrice);
            itemPanel.add(delBtn);
        }

        JLabel totalLabel = new JLabel("Total: $" + total);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 28));
        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.setSize(new Dimension(100, 30));
        checkoutBtn.setFont(new Font("Arial", Font.BOLD, 28));
        checkoutBtn.setForeground(Color.white);
        checkoutBtn.setFocusable(false);
        checkoutBtn.setBackground(Color.DARK_GRAY);
        if (items.isEmpty()) {
            checkoutBtn.setEnabled(false);
        } else {
            checkoutBtn.setEnabled(true);
        }
        checkoutBtn.addActionListener(e -> {
            Controller.loadCheckoutGUI();
        });

        bottomPanel.add(totalLabel);
        bottomPanel.add(checkoutBtn);

        frame.add(panel);
        frame.add(bottomPanel);
    }

    // create header for all GUI
    public static void header(JFrame frame) {
        JPanel headerPanel = new JPanel();
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        headerPanel.setBounds(0, 0, 1280, 60);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        JLabel appName = new JLabel("The Coffee Shop");
        appName.setFont(new Font("Ariel", Font.BOLD, 24));

        JButton menuBtn = new JButton("Menu");
        menuBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        menuBtn.setPreferredSize(new Dimension(200, 30));
        menuBtn.setFocusable(false);
        menuBtn.addActionListener(e -> {
            Controller.loadGUI(MENU);
        });

        JButton cartBtn = new JButton("Cart");
        cartBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        cartBtn.setPreferredSize(new Dimension(200, 30));
        cartBtn.setFocusable(false);
        cartBtn.addActionListener(e -> {
            Controller.loadCartGUI();
        });

        headerPanel.add(appName);
        headerPanel.add(menuBtn);
        headerPanel.add(cartBtn);
        frame.add(headerPanel);
    }

    // create item GUI
    public static void itemGUI(JFrame frame, Item item) {
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 100, 550, 400);
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(700, 130, 500, 400);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 20));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.black));
        bottomPanel.setBounds(100, 549, 1065, 200);

        JLabel itemName = new JLabel(item.getName());
        itemName.setFont(new Font("Arial", Font.BOLD, 28));

        Image img = new ImageIcon(item.getImg()).getImage();
        Image newImage = img.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(newImage));

        JTextArea itemDesc = new JTextArea(item.getDescribe());
        itemDesc.setLineWrap(true);
        itemDesc.setEditable(false);
        itemDesc.setBackground(null);
        itemDesc.setFont(new Font("Arial", Font.PLAIN, 18));
        itemDesc.setSize(new Dimension(800, 50));

        JLabel descTitle = new JLabel("Description");
        descTitle.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel itemPrice = new JLabel("$" + String.valueOf(item.getPrice()));
        itemPrice.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel sizeOptLabel = new JLabel("Size Options");
        sizeOptLabel.setFont(new Font("Arial", Font.BOLD, 20));
        sizeOptLabel.setAlignmentY(Component.TOP_ALIGNMENT);

        JButton addBtn = new JButton("Add to cart");
        addBtn.setFont(new Font("Ariel", Font.BOLD, 20));
        addBtn.setPreferredSize(new Dimension(200, 50));
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

    // create item for each menu
    public static void menuItem(String menuName, JPanel panel) {
        panel.removeAll();
        panel.setVisible(false);

        Item[] items = HandleData.getItemsOfCategory(menuName);
        int rows = (int) Math.ceil(items.length / 3.0);
        panel.setLayout(new GridLayout(rows, 3));
        for (Item item: items) {

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
            itemBtn.setPreferredSize(new Dimension(200, 235));
            itemBtn.addActionListener(e -> {
                Controller.loadItemGUI(item);
            });
            panel.add(itemBtn);
        }
        panel.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
