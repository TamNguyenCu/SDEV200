package model;

public class Coffee extends Item{
    public Coffee() {
        super();
    }

    @Override
    public String getCategory() {
        return "coffee";
    }
}
