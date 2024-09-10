package Chapter4.Exercises;
import java.util.Scanner;

public class TestSandwich {
    public static void main(String[] args) {
        Sandwich sandwich = createSandwich();
        displaySandwich(sandwich);
    }

    public static Sandwich createSandwich() {
        Sandwich sandwich = new Sandwich();
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert the main ingredients for the sandwich: ");
        sandwich.setMainIngredient(input.nextLine());
        System.out.println("Please insert the bread type for the sandwich: ");
        sandwich.setBreadType(input.nextLine());
        System.out.println("Please insert the price for the sandwich: ");
        sandwich.setPrice(input.nextDouble());
        return sandwich;
    }

    public static void displaySandwich(Sandwich sandwich) {
        System.out.println("--------Sandwich details--------");
        System.out.println("Main ingredient: " + sandwich.getMainIngredient());
        System.out.println("Bread type: " + sandwich.getBreadType());
        System.out.println("Price: $" + sandwich.getPrice());
    }
}
