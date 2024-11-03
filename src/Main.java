import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManager cm = new CustomerManager();
        Scanner sc = new Scanner(System.in);
        Customer loggedInCustomer = null; // Track the logged-in customer

        while (true) {
            System.out.println("Welcome to the Banking App");
            System.out.println("Which option would you like to choose?");
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.println("3: Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Please enter your full name:");
                    String name = sc.nextLine();
                    System.out.println("Please enter your password:");
                    String password = sc.nextLine();
                    loggedInCustomer = cm.loginCustomer(name, password); // Modified to return the logged-in customer

                    if (loggedInCustomer != null) {
                        System.out.println("Customer logged in successfully.");

                        // Show secondary menu for logged-in users
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("1: View balance");
                            System.out.println("2: Deposit");
                            System.out.println("3: Withdraw");
                            System.out.println("4: View transaction history");
                            System.out.println("5: Log out");

                            int choice2 = sc.nextInt();
                            sc.nextLine(); // Consume newline after nextInt()

                            Account account = loggedInCustomer.getAccounts().get(0); // Assumes the customer has one account

                            switch (choice2) {
                                case 1:
                                    System.out.println("Current balance: " + account.getBalance());
                                    break;
                                case 2:
                                    System.out.println("Enter amount to deposit:");
                                    double depositAmount = sc.nextDouble();
                                    sc.nextLine(); // Consume newline
                                    account.deposit(depositAmount);
                                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                                    break;
                                case 3:
                                    System.out.println("Enter amount to withdraw:");
                                    double withdrawAmount = sc.nextDouble();
                                    sc.nextLine(); // Consume newline
                                    if (withdrawAmount > account.getBalance()) {
                                        System.out.println("Insufficient balance. Withdrawal failed.");
                                    } else {
                                        account.withdraw(withdrawAmount);
                                        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                                    }
                                    break;

                                case 4:
                                    if (account.getTransactions().isEmpty()) {
                                        System.out.println("No transaction history available.");
                                    } else {
                                        for (Transaction transaction : account.getTransactions()) {
                                            System.out.println(transaction); // Calls the toString() method of the Transaction class
                                        }
                                    }
                                    break; // Add this break to avoid fall-through
                                    case 5:
                                    System.out.println("Logged out successfully.");
                                    loggedIn = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice, please try again.");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Please check your credentials.");
                    }
                    break;

                case 2:
                    System.out.println("Please enter your full name:");
                    name = sc.nextLine();
                    System.out.println("Please create a password:");
                    password = sc.nextLine();
                    cm.createAccount(name, password);
                    break;

                case 3:
                    System.out.println("Goodbye");
                    return; // Exit the loop and end the program

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
