package com.finalproject;

import model.MenuItem;

public class Main {
    public static void main(String[] args) {
        MenuItem[] menuItem = HandleData.getAllMenu();

        System.out.println("Today menu have: ");
        for (MenuItem item : menuItem) {
            System.out.println(item.getName());
        }

        MenuItem item = HandleData.getItem("Supreme Pizza");
        System.out.println(item.getName());
        System.out.println(item.getPrice());
    }
}