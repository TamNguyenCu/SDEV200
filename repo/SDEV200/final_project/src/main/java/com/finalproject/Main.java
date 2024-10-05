package com.finalproject;

import model.Item;
import model.MenuItem;

public class Main {
    public static void main(String[] args) {
        MenuItem[] menu = HandleData.getAllMenu();

        MenuGUI.loadMenuGUI();

        System.out.println("Today menu have: ");
        for (MenuItem m : menu) {
            for (Item i : m.getItems()) {
                System.out.println(i.getName());
            }
        }

        Item item = HandleData.getItem("Espresso");
        System.out.println(item.getName());
        System.out.println(item.getPrice());
    }
}