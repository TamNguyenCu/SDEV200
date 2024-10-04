package Chapter10.Tutorials;

public class HighBalanceException extends Exception {
    public HighBalanceException() {
        super("Customer balance is high");
    }
}
