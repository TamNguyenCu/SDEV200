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
    
    public static void startApplication() {
        menuFrame = new GUI();
        cartFrame = new GUI();
        itemFrame = new GUI();
        checkoutFrame = new GUI();
        GUI.menuGUI(menuFrame);
        loadGUI(GUI.MENU);
    }

    public static void loadGUI(String frame) {
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

    public static void loadCartGUI() {
        cartFrame.dispose();
        cartFrame = new GUI();
        GUI.cartGUI(cartFrame, selectedItems);
        loadGUI(GUI.CART);
    }

    public static void loadCheckoutGUI() {
        checkoutFrame.dispose();
        checkoutFrame = new GUI();
        GUI.checkoutGUI(checkoutFrame, selectedItems);
        loadGUI(GUI.CHECKOUT);
    }

    public static void loadItemGUI(Item item) {
        itemFrame.dispose();
        itemFrame = new GUI();
        GUI.itemGUI(itemFrame, item);
        loadGUI(GUI.ITEM);
    }

    public static void addToCart(String itemName, String category, double addPrice) {
        Item item = HandleData.getItem(itemName, category);
        item.setPrice(item.getPrice() + addPrice);
        selectedItems.add(item);

        JOptionPane.showMessageDialog(cartFrame, "You have added " + itemName + 
            " to your cart. There are now " + selectedItems.size() + " items in your cart.", 
            "Added to cart", JOptionPane.PLAIN_MESSAGE);
    }

    public static void checkout() {
        JOptionPane.showMessageDialog(checkoutFrame, "Your order has been placed. Thank you!", 
        "Order placed", JOptionPane.PLAIN_MESSAGE);
        printReceipt(selectedItems);
        selectedItems = new ArrayList<Item>();
        loadGUI(GUI.MENU);
    }

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
