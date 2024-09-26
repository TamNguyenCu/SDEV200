package com.finalproject;

import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

import model.MenuItem;

public class Main {
    public static void main(String[] args) {
        try {
            Object obj = new JSONParser().parse(new FileReader("MyTestFile"));
            JSONObject jo = (JSONObject) obj;
            
            String name = jo.get("name");
            
            System.out.println("item name: " + name);

        } catch (FileNotFoundException ex) {
            System.err.println("Cannot find file");
        }
    }
}