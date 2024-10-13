package com.finalproject;

import java.io.FileReader;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Item;

public class HandleData {
    // Get a specific item from the specified category
    public static Item getItem(String itemName, String category) {
        Item item = new Item();
        for (Item i : getItemsOfCategory(category)) {
            if (i.getName().equals(itemName)) {
                item = i;
            }
        }
        return item;
    }

    // Get all items of a specific category
    public static Item[] getItemsOfCategory(String category) {
        Item[] items = new Item[]{};
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FileReader reader = new FileReader(FilePath.menuItem());
            Object obj = new JSONParser().parse(reader);
            JSONObject jo = (JSONObject) obj;
            JSONArray ja = (JSONArray) jo.get(category);
            items = objectMapper.readValue(ja.toJSONString(), Item[].class);

        } catch (Exception ex) {
            System.err.println("Something went wrong: " + Arrays.toString(ex.getStackTrace()));
        }
        return items;
    }
}
