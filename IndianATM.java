import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {3
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class IndianATM {
    private BankAccount account;

    public IndianATM(BankAccount account) {
        this.account = account;
    }

    private void displayMenu() {
        System.out.println("\nIndian ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount (INR): ");
                        processDeposit(scanner);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount (INR): ");
                        processWithdrawal(scanner);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thank you for using the Indian ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }

    private void processDeposit(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            System.out.println("Deposit of ₹" + depositAmount + " successful.");
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }

    private void processWithdrawal(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            double withdrawAmount = scanner.nextDouble();
            if (account.withdraw(withdrawAmount)) {
                System.out.println("Withdrawal of ₹" + withdrawAmount + " successful.");
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000); 
        IndianATM atm = new IndianATM(userAccount);
        atm.run();
    }
}