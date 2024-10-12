package Chapter11.Exercises;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudentsStanding2 {
    public static void main(String[] args) {
        final String GS_STUDENT = "good_standings_student";
        final String PB_STUDENT = "probations_student";
        readFile(GS_STUDENT, "Student In Good Standing");
        readFile(PB_STUDENT, "Student on Academic Probation");
    }

    public static void readFile(String fileName, String header) {
        final double AVG_POINT = 2.0;
        String[] array = new String[4];
        String s = "";
        String delimeter = ", ";
        String id;
        String firstName;
        String lastName;
        double avgPoint;
        String devPoint;
        Path file = Paths.get("C:\\Users\\Public\\Desktop\\" + fileName + ".txt");
        try {
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            System.out.println();
            s = reader.readLine();
            System.out.println(header);
            System.out.println("#ID\tFName\tLName\tAvgPoint");
            while (s != null) {
                array = s.split(delimeter);
                id = array[0];
                if (id != null) {
                    firstName = array[1];
                    lastName = array[2];
                    avgPoint = Double.parseDouble(array[3]);
                    if (avgPoint > AVG_POINT) {
                        devPoint = "greater than the " + AVG_POINT + " cutoff " + String.format("%.1f", (avgPoint - AVG_POINT)) + " points";
                    } else {
                        devPoint = String.format("%.1f", (AVG_POINT - avgPoint)) + " points short of the " + AVG_POINT + " cutoff";
                    }
                    System.out.println(id + "\t" + firstName + "\t" + lastName + "\t" + avgPoint + "  -  " + devPoint);
                }
                s = reader.readLine();
            }
            reader.close();
            System.out.println("------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }
}
