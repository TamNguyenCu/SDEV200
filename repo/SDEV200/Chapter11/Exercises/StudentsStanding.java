package Chapter11.Exercises;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsStanding {
    public static void main(String[] args) {
        final String QUIT = "ZZZ";
        final String GS_STUDENT = "good_standings_student";
        final String PB_STUDENT = "probations_student";
        final double AVG_POINT = 2.0;
        String studentID;

        List<Student> goodStandingStudents = new ArrayList<Student>();
        List<Student> probationStudents = new ArrayList<Student>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID or " + QUIT + " to quit >> ");
        studentID = input.nextLine();
        
        while (!studentID.equals(QUIT)) {
            Student student = new Student();
            student.setId(studentID);
            System.out.print("Enter student first name >> ");
            student.setFirstName(input.nextLine());
            System.out.print("Enter student last name >> ");
            student.setLastName(input.nextLine());
            System.out.print("Enter student average grade point >> ");
            student.setAvgPoints(input.nextDouble());

            if (student.getAvgPoints() >= AVG_POINT) {
                goodStandingStudents.add(student);
            } else {
                probationStudents.add(student);
            }
            input.nextLine();

            System.out.print("Enter next student ID or " + QUIT + " to quit >> ");
            studentID = input.nextLine();
        }

        exportFile(GS_STUDENT, goodStandingStudents);
        exportFile(PB_STUDENT, probationStudents);
    }

    public static void exportFile(String fileName, List<Student> students) {
        Path filePath = 
            Paths.get("C:\\Users\\Public\\Desktop\\" + fileName + ".txt");
        String s = "";
        String delimeter = ", ";
        try {
            OutputStream output = new 
                BufferedOutputStream(Files.newOutputStream(filePath, CREATE));
            BufferedWriter writer = new
                BufferedWriter(new OutputStreamWriter(output));
            
            for (Student student : students) {
                s = student.getId() + delimeter + student.getFirstName() + 
                    delimeter + student.getLastName() + delimeter + student.getAvgPoints();
                writer.write(s, 0, s.length());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }
}
