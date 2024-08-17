import java.util.Scanner;

public class ATMdemo {

    // Class to represent the bank account
    static class BankAccount {
        private double balance;

        // Constructor to initialize the balance
        public BankAccount(double initialBalance) {
            balance = initialBalance;
        }

        // Method to get the current balance
        public double getBalance() {
            return balance;
        }

        // Public method to deposit money into account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully Deposited: $" + amount + " into the Account.");
            } else {
                System.out.println("Failed! Invalid deposit amount.");
            }
        }

        // Method to withdraw money from the account
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully Withdrew: $" + amount + " from Account.");
                return true;
            } else {
                System.out.println("Failed! Insufficient funds or invalid amount.");
                return false;
            }
        }
    }

    // Class that represent the ATM machine
    static class ATM {
        private BankAccount account; // Reference to the user's bank account
        private Scanner scanner; // Scanner to read user input

        ATM(BankAccount account) // Constructor to initialize the ATM with a bank account
        {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        private void checkBalance() {
            System.out.println("Current balance: $" + account.getBalance());
        }

        private void deposit() {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }

        private void withdraw() {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }

        public void showMenu() {
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt(); // Read user choice

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Exiting......");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

    }

    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount account = new BankAccount(500);

        ATM atm = new ATM(account);

        atm.showMenu();// Show the ATM menu
    }
}
