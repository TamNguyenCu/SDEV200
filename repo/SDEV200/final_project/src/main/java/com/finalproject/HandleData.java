package com.finalproject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Item;
import model.Menu;

public class HandleData {

    private static Menu[] menus = new Menu[]{};
    final static int CATEGORIES = 3;

    private static boolean isMenuEmpty() {
        return menus.length == 0 ? true : false;
    }

    public static Menu[] getAllMenu() {
        Menu[] m = new Menu[]{};
        if (isMenuEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                FileReader reader = new FileReader(FilePath.menuItem());
                Object json = new JSONParser().parse(reader);
                m = objectMapper.readValue(json.toString(), Menu[].class);
                menus = m;
            } catch (Exception ex) {
                System.err.println("Something went wrong: " + Arrays.toString(ex.getStackTrace()));
            }
        } else {
            m = menus;
        }
        return m;
    }

    public static Menu getMenu(String category) {
        Menu menu = new Menu();
        for (Menu m : menus) {
            if (m.getCategory().equals(category)) {
                menu = m;
            }
        }
        return menu;
    }

    public static ArrayList<Item> getItemsInCategory(String category) {
        ArrayList<Item> itemsInCategory = new ArrayList<>();
        for (Menu m : menus) {
            if (m.getCategory().equals(category)) {
                itemsInCategory = (ArrayList<Item>) m.getItems();
            }
        }
        return itemsInCategory;
    }

    public static Item getItem(String itemName) {
        Item item = new Item();
        for (Menu m : menus) {
            for (Item i: m.getItems()) {
                if (i.getName().equalsIgnoreCase(itemName)) {
                    item = i;
                }
            }
        }
        return item;
    }
}
