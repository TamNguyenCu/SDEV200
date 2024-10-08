package Chapter12.Tutorials;
import java.util.Scanner;

public class RemoveDashes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String phone;
        System.out.print("Enter phone number >> ");
        phone = input.nextLine();
        removeDashes(phone);
        System.out.println();
    }

    public static void removeDashes(String s) {
        int dashLoc = s.indexOf('-');
        if (dashLoc == -1) {
            System.out.print(s);
        } else {
            removeDashes(s.substring(0, dashLoc));
            removeDashes(s.substring(dashLoc + 1));
        }
    }
}
