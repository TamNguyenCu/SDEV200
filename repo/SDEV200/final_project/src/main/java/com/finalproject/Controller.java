package com.finalproject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.StandardOpenOption.CREATE;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Item;

public class Controller {
    static JFrame menuFrame;
    static JFrame cartFrame;
    static JFrame itemFrame;
    static JFrame checkoutFrame;
    static List<Item> selectedItems = new ArrayList<Item>();
    
    // Start the application
    public static void startApplication() {
        // Create frames
        menuFrame = new GUI();
        cartFrame = new GUI();
        itemFrame = new GUI();
        checkoutFrame = new GUI();
        // Create menu GUI and set visible
        GUI.menuGUI(menuFrame);
        loadGUI(GUI.MENU);
    }

    public static void loadGUI(String frame) {
        // Set visible based on the frame
        switch (frame) {
            case GUI.MENU:
                menuFrame.setVisible(true);
                cartFrame.setVisible(false);
                itemFrame.setVisible(false);
                checkoutFrame.setVisible(false);
                break;
            case GUI.CART:
                menuFrame.setVisible(false);
                cartFrame.setVisible(true);
                itemFrame.setVisible(false);
                checkoutFrame.setVisible(false);
                break;
            case GUI.ITEM:
                menuFrame.setVisible(false);
                cartFrame.setVisible(false);
                itemFrame.setVisible(true);
                checkoutFrame.setVisible(false);
                break;
            case GUI.CHECKOUT:
                menuFrame.setVisible(false);
                cartFrame.setVisible(false);
                itemFrame.setVisible(false);
                checkoutFrame.setVisible(true);
                break;
            default:
                System.err.println("Invalid frame");;
        }    
    }

    // load cart GUI
    public static void loadCartGUI() {
        // dispose and create new GUI
        cartFrame.dispose();
        cartFrame = new GUI();
        GUI.cartGUI(cartFrame, selectedItems);
        loadGUI(GUI.CART);
    }

    // load checkout GUI
    public static void loadCheckoutGUI() {
        // dispose and create new GUI
        checkoutFrame.dispose();
        checkoutFrame = new GUI();
        GUI.checkoutGUI(checkoutFrame, selectedItems);
        loadGUI(GUI.CHECKOUT);
    }

    // load item GUI
    public static void loadItemGUI(Item item) {
        // dispose and create new GUI
        itemFrame.dispose();
        itemFrame = new GUI();
        GUI.itemGUI(itemFrame, item);
        loadGUI(GUI.ITEM);
    }

    // add item to cart
    public static void addToCart(String itemName, String category, double addPrice) {
        Item item = HandleData.getItem(itemName, category);
        item.setPrice(item.getPrice() + addPrice);
        selectedItems.add(item);

        JOptionPane.showMessageDialog(cartFrame, "You have added " + itemName + 
            " to your cart. There are now " + selectedItems.size() + " items in your cart.", 
            "Added to cart", JOptionPane.PLAIN_MESSAGE);
        
        for (Item i: selectedItems) {
            System.out.println(i.getName());
        }
    }

    // checkout process
    public static void checkout() {
        JOptionPane.showMessageDialog(checkoutFrame, "Your order has been placed. Thank you!", 
        "Order placed", JOptionPane.PLAIN_MESSAGE);
        printReceipt(selectedItems);
        selectedItems = new ArrayList<Item>();
        loadGUI(GUI.MENU);
    }

    // export receipt file
    public static void printReceipt(List<Item> items) {
        Path filePath = 
            Paths.get("C:\\Users\\Public\\Desktop\\Order_Receipt.txt");
        String s = "";
        String delimeter = "...........................";
        try {
            OutputStream output = new 
                BufferedOutputStream(Files.newOutputStream(filePath, CREATE));
            BufferedWriter writer = new
                BufferedWriter(new OutputStreamWriter(output));
            
            for (int i = 0; i < items.size(); i++) {
                Item item = selectedItems.get(i);
                int index = i + 1;
                s = index + "/" + item.getName() + delimeter + item.getPrice();
                writer.write(s, 0, s.length());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }
}
