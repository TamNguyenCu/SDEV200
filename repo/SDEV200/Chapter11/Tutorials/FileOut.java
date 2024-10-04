package Chapter11.Tutorials;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileOut {
    public static void main(String[] args) {
        Path filePath = 
            Paths.get("C:\\Java\\Chapter.11\\Grades.txt");
        String s = "ABCDF";
        byte[] data = s.getBytes();
        OutputStream output = null;
        try {
            output = new 
                BufferedOutputStream(Files.newOutputStream(filePath, CREATE));
            output.write(data);
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }
}
