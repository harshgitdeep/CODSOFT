import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println();
            System.out.println("Deposit successful");
            System.out.println();
            System.out.println("Your new balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println();
            System.out.println("Withdrawal successful!");
            System.out.println();
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;
    public ATM(BankAccount account) {
        bankAccount = account;
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        boolean continueRunning = true;
        do {
            System.out.println("\n-----------Welcome to CodBank---------");
            System.out.println();
            System.out.println("Press the button : ");
            System.out.println();
            System.out.println("Press 1 ---> Check Balance");
            System.out.println("Press 2 ---> Deposit");
            System.out.println("Press 3 ---> Withdraw");
            System.out.println("Press 4 ---> Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

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
                    System.out.println();
                    System.out.println("Thank you for using the CodBank ATM!");
                    System.out.println("Have a good day!");
                    System.out.println();
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option between 1 to 4");
            }

            if (continueRunning) {
                System.out.println();
                System.out.print("Do you want to continue? (yes/no): ");
                String response = scanner.next();
                if (!response.equals("yes")) {
                    System.out.println("Thank you for using the CodBank ATM!");
                    System.out.println("Have a good day!");
                    continueRunning = false;
                }
            }
        } while (continueRunning);
    }

    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println();
        System.out.println("Your account balance: " + balance);
        System.out.println();
    }

    private void deposit() {
        System.out.println();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void withdraw() {
        System.out.println();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);
        ATM atm = new ATM(account);
        atm.run();
    }
}
