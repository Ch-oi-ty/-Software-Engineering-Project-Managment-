import java.util.Scanner;

public class ATMmachine {
    private static double balance = 1000.00; // Default balance for the user

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userChoice;

        System.out.println("Welcome to the ATM!");
        System.out.println("You1r current balance is: $" + balance);

        do {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    depositMoney(sc);
                    break;

                case 3:
                    withdrawMoney(sc);
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (userChoice != 4);

        sc.close();
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit money
    public static void depositMoney(Scanner sc) {
        System.out.println("Enter the amount to deposit:");
        double depositAmount = sc.nextDouble();

        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Deposited: $" + depositAmount);
            System.out.println("Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney(Scanner sc) {
        System.out.println("Enter the amount to withdraw:");
        double withdrawAmount = sc.nextDouble();

        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("Withdrew: $" + withdrawAmount);
            System.out.println("Your new balance is: $" + balance);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient funds. Please enter a smaller amount.");
        } else {
            System.out.println("Invalid withdraw amount. Please enter a positive value.");
        }
    }
}

