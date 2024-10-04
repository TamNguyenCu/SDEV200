package Chapter11.Tutorials;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static void main(String[] args) {
        Path filePath = 
            Paths.get("C:\\Java\\Chapter.11\\Grades.txt");
        InputStream input = null;
        try {
            input = Files.newInputStream(filePath);
            BufferedReader reader = new 
                BufferedReader(new InputStreamReader(input));
            String s = null;
            s = reader.readLine();
            System.out.println(s);
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
