package Chapter9.Exercises;

public class Fiction extends Book {

    public Fiction(String title) {
        super(title);
    }
    
    @Override
    public void setPrice() {
        this.price = 24.99;
    }
}
