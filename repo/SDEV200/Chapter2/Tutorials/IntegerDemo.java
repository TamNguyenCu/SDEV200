package Chapter2.Tutorials;

public class IntegerDemo {

    public static void main(String[] args) {
        int aInt = 1234;
        byte aByte = 12;
        short aShort = 12345;
        long aLong = 1234567890987654321L;
        int anotherInt = aInt * 100000000;

        System.out.println("The int is:     " + aInt);
        System.out.println("The byte is:    " + aByte);
        System.out.println("The short is:   " + aShort);
        System.out.println("The long is:    " + aLong);
        System.out.println("Another int is: " + anotherInt);
    }
}
