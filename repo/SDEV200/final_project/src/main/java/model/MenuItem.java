package model;

import java.util.List;
import java.util.Map;

public class MenuItem {
    private String name;
    private Map<String, Integer> toppings;
    private List<String> sizes;
    private List<String> crust;
    private double price;
    private String image_path;

    public MenuItem() {}

    public List<String> getSizes() {
        return this.sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getCrust() {
        return this.crust;
    }

    public void setCrust(List<String> crust) {
        this.crust = crust;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_path() {
        return this.image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Map<String,Integer> getToppings() {
        return this.toppings;
    }

    public void setToppings(Map<String,Integer> toppings) {
        this.toppings = toppings;
    }
}
