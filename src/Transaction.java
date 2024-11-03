import java.util.Date;

public class Transaction {
    private static int idCounter = 0; // Static counter for unique IDs
    private int transactionID;
    private String transactionType;
    private Date transactionDate;
    private double amount;

    public Transaction(String transactionType, Date transactionDate, double amount) {
        this.transactionID = ++idCounter; // Auto-increment ID
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Type: " + transactionType + ", Date: " + transactionDate + ", Amount: " + amount;
    }
}
