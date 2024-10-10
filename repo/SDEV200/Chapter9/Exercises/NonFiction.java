package Chapter9.Exercises;

public class NonFiction extends Book {

    public NonFiction(String title) {
        super(title);
    }
    
    @Override
    public void setPrice() {
        this.price = 37.99;
    }
}
