public class Account {

    private int accountNumber;
    private double balance;
    private String accountType;

    public Account(int accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }


    //Getters
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }


    //Deposit method
    public void deposit(double amount) {
        balance += amount;
    }
    //Withdraw
    public void withdraw(double amount) {
        balance -= amount;
    }
}
