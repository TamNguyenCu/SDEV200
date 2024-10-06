package Chapter13.Tutorials;

public class Purchase implements Comparable<Purchase> {
    private String category;
    private double price;

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Purchase(String cat, double pr) {
        category = cat;
        price = pr;
    }

    @Override
    public int compareTo(Purchase p) {
        int result;
        result = category.compareTo(p.getCategory());
        return result;
    }
}
