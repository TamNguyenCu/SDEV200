package Chapter10.Tutorials;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionMistakeCaught3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator, denominator, result;
        try {
            System.out.print("Enter numerator >> ");
            numerator = scanner.nextInt();
            System.out.print("Enter denominator >> ");
            denominator = scanner.nextInt();
            result = numerator / denominator;
            System.out.println(numerator + " / " + denominator + " = " + result);
            
        } catch (ArithmeticException mistake) {
            System.out.println(mistake.getMessage());
        } catch (InputMismatchException mistake) {
            System.out.println("wrong data type");
        }
        System.out.println("End of program");
    }
}
