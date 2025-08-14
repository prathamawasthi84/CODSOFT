import java.util.Scanner;
class Account {
    private double balance;

    public Account(double openingAmount) {
        balance = openingAmount;
    }

    public boolean depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getCurrentBalance() {
        return balance;
    }
}
class ATMSystem {
    private Account linkedAccount;
    private Scanner input;

    public ATMSystem(Account account) {
        linkedAccount = account;
        input = new Scanner(System.in);
    }

    public void operateATM() {
        int option;
        do {
            showMenu();
            option = getChoice();

            switch (option) {
                case 1 -> displayBalance();
                case 2 -> handleDeposit();
                case 3 -> handleWithdrawal();
                case 4 -> System.out.println("Session ended. Please take your card.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (option != 4);
    }

    private void showMenu() {
        System.out.println("\n========= Welcome to ATM =========");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    private int getChoice() {
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            input.next();
        }
        return input.nextInt();
    }

    private void displayBalance() {
        System.out.println("[DEBUG] Display balance method called.");
        System.out.printf("Your balance: ₹%.2f%n", linkedAccount.getCurrentBalance());
    }


    private void handleDeposit() {
        System.out.print("Enter deposit amount: ₹");
        double amount = input.nextDouble();
        if (linkedAccount.depositMoney(amount)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter withdrawal amount: ₹");
        double amount = input.nextDouble();
        if (linkedAccount.withdrawMoney(amount)) {
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Transaction failed. Check balance or amount entered.");
        }
    }
}
public class ATMInterface {
    public static void main(String[] args) {
        Account myAccount = new Account(3000); // starting balance
        ATMSystem atmMachine = new ATMSystem(myAccount);
        atmMachine.operateATM();
    }
}
