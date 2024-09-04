// Filename BookstoreCredit.java
// Written by Tam Nguyen Cu
// Written on September 01 2024
package Chapter3.Exercises;

// Import modules
import javax.swing.JOptionPane;

public class BookstoreCredit {

    /* This class allows students to enter their name and grade point average (GPA) 
to calculate the bookstore credit they will receive 10 times their GPA.*/
    public static void main(String[] args) {

        // Get the name and GPA from the studen
        String studentName = displayInputDialog("Please enter your name: ", "Student's Name");
        String inputGradePoint = displayInputDialog("Please enter your grade point average (GPA): ", "Student's GPA");

        // Calculate the credit
        float totalCredit = calCreditOnGPA(Float.parseFloat(inputGradePoint));
        String message = "Name: " + studentName + "\nGPA: " + inputGradePoint
                + "\nCredit: $" + totalCredit;

        // Display the results
        displayMsgDialog(message, "Student's Bookstore Credit", 1);
    }

    public static String displayInputDialog(String msg, String title) {
        // Display input dialog
        return JOptionPane.showInputDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static float calCreditOnGPA(float gpa) {
        // Calculate the credit
        return gpa * 10;
    }

    public static void displayMsgDialog(String message, String title, int messageType) {
        // Display message dialog
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
