import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class CustomerManager {

    // Scanner for input
    Scanner scanner = new Scanner(System.in);

    // Fields
    private ArrayList<Customer> customers; // Fixed type declaration
    private int nextCustomerId; // Added type
    private Map<String, Customer> customerMapById;
    private Logger logger;

    // Constructor
    public CustomerManager() {
        this.customers = new ArrayList<>();
        this.nextCustomerId = 1;
        this.customerMapById = new HashMap<>();
        this.logger = Logger.getLogger(CustomerManager.class.getName());
    }

    // Method to register a new customer
    public void createAccount(String name, String password) {
        Customer newCustomer = new Customer(name, password, nextCustomerId++);

        Account newAccount = new Account(newCustomer.getId(), 0.0, "Savings");

        newCustomer.addAccount(newAccount);

        customers.add(newCustomer);
        customerMapById.put(String.valueOf(newCustomer.getId()), newCustomer);

        logger.info("New customer registered: " + newCustomer.getName());
        System.out.println("Account created successfully for " + newCustomer.getName());
    }

    // Method to log in a customer
    public Customer  loginCustomer(String name, String password) {
        boolean loggedIn = false;

        for (Customer customer : customers) {
            if (name.equals(customer.getName()) && password.equals(customer.getPassword())) {
                System.out.println("Customer logged in succesfully");
                loggedIn = true;
                return customer; // Exit method after successful login
            }
        }

        if (!loggedIn) {
            System.out.println("Wrong customer credentials");

        }
        return null;
    }

}

