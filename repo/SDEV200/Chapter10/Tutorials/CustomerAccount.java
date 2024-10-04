package Chapter10.Tutorials;

public class CustomerAccount {
    private int acctNum;
    private double balance;
    public static double HIGH_CREDIT_LIMIT = 20000.00;
    public CustomerAccount(int num, double bal) throws HighBalanceException{
        this.acctNum = num;
        this.balance = bal;
        if (this.balance > HIGH_CREDIT_LIMIT) {
            throw (new HighBalanceException());
        }
    }
}
