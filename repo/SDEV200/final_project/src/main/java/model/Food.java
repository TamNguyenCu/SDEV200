package model;

public class Food extends Item{
    public Food() {
        super();
    }

    @Override
    public String getCategory() {
        return "food";
    }
}
