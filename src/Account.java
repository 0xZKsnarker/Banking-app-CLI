import java.util.ArrayList;
import java.util.Date;

public class Account {

    private int accountNumber;
    private double balance;
    private String accountType;
    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
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
        Date transactionDate = new Date();
        balance += amount;
        transactions.add(new Transaction("Deposit", transactionDate, amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            Date transactionDate = new Date();
            balance -= amount;
            transactions.add(new Transaction("Withdraw", transactionDate, amount));
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
