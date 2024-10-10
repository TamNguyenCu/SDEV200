package Chapter9.Exercises;

public abstract class Book {
    private String title;
    protected double price;
    
    public Book (String title) {
        setTitle(title);
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public abstract void setPrice();

    public void setTitle(String title) {
        this.title = title;
    }
}
