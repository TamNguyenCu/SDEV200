package Chapter9.Exercises;

import java.util.Scanner;

public class BookArray {
    public static void main(String[] args) {
        final int BOOK_LIMIT = 10;
        final String FICTION = "F";
        final String NON_FICTION = "N";

        String bookType;
        int count = 0;

        Book[] listOfBooks = new Book[BOOK_LIMIT];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter F for ficion book and N for non-ficion book >>> ");
        bookType = input.nextLine();

        while (count < BOOK_LIMIT) {
            if (bookType.equals(FICTION)) {
                // Create a fiction book
                System.out.print("Enter a name for the fiction book >> ");
                Fiction fictionBook = new Fiction(input.nextLine());
                fictionBook.setPrice();
                listOfBooks[count] = fictionBook;
                ++count;
            }

            if (bookType.equals(NON_FICTION)) {
                // Create a non-fiction book
                System.out.print("Enter a name for the non fiction book >> ");
                NonFiction nonFictionBook = new NonFiction(input.nextLine());
                nonFictionBook.setPrice();
                listOfBooks[count] = nonFictionBook;
                ++count;
            }

            if (count < BOOK_LIMIT) {
                System.out.print("Enter F for ficion book and N for non-ficion book >>> ");
                bookType = input.nextLine();
            }
        }


        System.out.println("The list of books:");
        for (int i = 0; i < listOfBooks.length; i++) {
            System.out.println(i+1 + ". " + listOfBooks[i].getTitle() + ": $" + listOfBooks[i].getPrice());
        }
    }
}
