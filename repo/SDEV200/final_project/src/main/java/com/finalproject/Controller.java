package com.finalproject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Item;

public class Controller {
    static JFrame menuFrame;
    static JFrame cartFrame;
    static JFrame itemFrame;
    static List<Item> selectedItems = new ArrayList<Item>();
    
    public static void startApplication() {
        menuFrame = GUI.createFrame();
        cartFrame = GUI.createFrame();
        itemFrame = GUI.createFrame();
        GUI.loadMenuGUI(menuFrame);
        GUI.loadCartGUI(cartFrame);
        
        loadGUI(GUI.MENU);
    }

    public static void loadGUI(String frame) {
        switch (frame) {
            case GUI.MENU:
                menuFrame.setVisible(true);
                cartFrame.setVisible(false);
                itemFrame.setVisible(false);
                break;
            case GUI.CART:
                menuFrame.setVisible(false);
                cartFrame.setVisible(true);
                itemFrame.setVisible(false);
                break;
            case GUI.ITEM:
                menuFrame.setVisible(false);
                cartFrame.setVisible(false);
                itemFrame.setVisible(true);
                break;
            default:
                System.err.println("Invalid frame");;
        }    
    }

    public static void loadItemGUI(Item item) {
        itemFrame.dispose();
        itemFrame = GUI.createFrame();
        GUI.loadItemGUI(itemFrame, item);
        loadGUI(GUI.ITEM);
    }

    public static void addToCart(String itemName, String category, double addPrice) {
        Item item = HandleData.getItem(itemName, category);
        item.setPrice(item.getPrice() + addPrice);
        selectedItems.add(item);

        JOptionPane.showMessageDialog(cartFrame, "You have added " + itemName + 
            " to your cart. There are now " + selectedItems.size() + " items in your cart.", 
            "Added to cart", JOptionPane.PLAIN_MESSAGE);
        System.out.println("--------------");
        for (Item it : selectedItems) {
            System.out.println(it.getName() + ": " + it.getPrice());
        }
    }
}
