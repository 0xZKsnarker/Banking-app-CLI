import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Customer {

    private String name;
    private String password;
    private int id; // Changed `Id` to `id` to follow naming conventions.
    private ArrayList<Account> accounts; // Renamed to `accounts`.

    // Constructor
    public Customer(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.accounts = new ArrayList<>(); // Initialize to an empty list.
    }

    // Constructor with accounts list
    public Customer(String name, String password, int id, ArrayList<Account> accounts) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.accounts = accounts != null ? accounts : new ArrayList<>(); // Ensure it's initialized.
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName; // Fixed incorrect assignment.
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to add an account
    public void addAccount(Account newAccount) {
        if (newAccount != null) {
            accounts.add(newAccount);
        }
    }
}
