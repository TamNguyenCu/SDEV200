package Chapter2.Tutorials;
import java.util.Scanner;

public class IntegerDemoInteractive {
    public static void main(String[] args) {
        int aInt;
        byte aByte;
        short aShort;
        long aLong;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter an integer >>");
        aInt = input.nextInt();
        System.out.print("Please enter a byte integer >>");
        aByte = input.nextByte();
        System.out.print("Please enter a short integer >>");
        aShort = input.nextShort();
        System.out.print("Please enter a long integer >>");
        aLong = input.nextLong();

        System.out.println("The int is:   " + aInt);
        System.out.println("The byte is:  " + aByte);
        System.out.println("The short is: " + aShort);
        System.out.println("The long is:  " + aLong);
    }
}
