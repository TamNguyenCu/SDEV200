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

        // Get the name and GPA from the student
        String studentName = JOptionPane.showInputDialog(null,
                "Please enter your name: ", "Student's Name", JOptionPane.PLAIN_MESSAGE);
        String inputGradePoint = JOptionPane.showInputDialog(null,
                "Please enter your grade point average (GPA): ", "Student's GPA", JOptionPane.PLAIN_MESSAGE);

        // Calculate the credit
        float totalCredit = Float.parseFloat(inputGradePoint) * 10;
        String message = "Name: " + studentName + "\nGPA: " + inputGradePoint
                + "\nCredit: $" + totalCredit;

        // Display the results
        JOptionPane.showMessageDialog(null, message, "Student's Bookstore Credit", 1);
    }
}
