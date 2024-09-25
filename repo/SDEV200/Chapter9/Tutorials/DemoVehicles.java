package Chapter9.Tutorials;
import javax.swing.*;

public class DemoVehicles {
    public static void main(String[] args) {
        Sailboat aBoat = new Sailboat();
        Bicycle aBicycle = new Bicycle();
        JOptionPane.showMessageDialog(null,
            "\nVehicle description:\n" + 
            aBoat.toString() + "\n" + aBicycle.toString());
    }
}
