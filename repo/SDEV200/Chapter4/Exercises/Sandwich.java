package Chapter4.Exercises;

public class Sandwich {
    private String mainIngredient;
    private String breadType;
    private double  price;

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}

