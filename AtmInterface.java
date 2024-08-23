import java.util.Scanner;

class AtmAccount {
    private double balance;

    public AtmAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }
}

class ATM {
    private AtmAccount bankAccount;

    public ATM(AtmAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Interface");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.println("Enter deposit amount: $");
                double depositAmount = sc.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Enter withdraw amount: $");
                double withdrawalAmount = sc.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter initial account balance: $");
        double initialBalance = sc.nextDouble();
        AtmAccount bankAccount = new AtmAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.println("Select an option:");
            int choice = sc.nextInt();
            atm.performTransaction(choice, sc);
        }
    }
}
