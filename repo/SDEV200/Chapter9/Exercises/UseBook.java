package Chapter9.Exercises;

import java.util.Scanner;

public class UseBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create a fiction book
        System.out.print("Enter a name for the fiction book >> ");
        Fiction fictionBook = new Fiction(input.nextLine());
        fictionBook.setPrice();

        // Create a non-fiction book
        System.out.print("Enter a name for the non fiction book >> ");
        NonFiction nonFictionBook = new NonFiction(input.nextLine());
        nonFictionBook.setPrice();

        // Display the list of books
        System.out.println("The list of books:");
        System.out.println(fictionBook.getTitle() + ": $" + fictionBook.getPrice());
        System.out.println(nonFictionBook.getTitle() + ": $" + nonFictionBook.getPrice());
    }
}
