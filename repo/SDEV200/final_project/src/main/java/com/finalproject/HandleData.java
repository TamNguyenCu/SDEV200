package com.finalproject;

import java.io.FileReader;
import java.util.Arrays;

import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Item;
import model.MenuItem;

public class HandleData {

    private static MenuItem[] menuItems = new MenuItem[]{};

    private static boolean isMenuEmpty() {
        return menuItems.length == 0 ? true : false;
    }

    public static MenuItem[] getAllMenu() {
        MenuItem[] menu = new MenuItem[]{};
        if (isMenuEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                FileReader reader = new FileReader(FilePath.menuItem());
                Object json = new JSONParser().parse(reader);
                menu = objectMapper.readValue(json.toString(), MenuItem[].class);
                menuItems = menu;
            } catch (Exception ex) {
                System.err.println("Something went wrong: " + Arrays.toString(ex.getStackTrace()));
            }
        } else {
            menu = menuItems;
        }
        return menu;
    }

    public static Item getItem(String itemName) {
        Item item = new Item();
        for (MenuItem menuItem : menuItems) {
            for (Item i: menuItem.getItems()) {
                if (i.getName().equalsIgnoreCase(itemName)) {
                    item = i;
                }
            }
        }
        return item;
    }
}
