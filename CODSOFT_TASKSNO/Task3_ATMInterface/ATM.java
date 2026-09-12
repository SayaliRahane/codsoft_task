import java.util.Scanner;

public class ATM {
    
    private BankAccount account;
    private Scanner scanner;
    
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    
    public void startATM() {
        boolean running = true;
        
        while (running) {
            showMenu();
            int choice = getValidChoice();
            
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
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    private void showMenu() {
        System.out.println("===== ATM INTERFACE =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }
    
    private int getValidChoice() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void checkBalance() {
        System.out.println();
        System.out.printf("Current Balance: ₹%.2f\n", account.getBalance());
    }
    
    private void deposit() {
        System.out.println();
        System.out.print("Enter deposit amount: ");
        
        double amount = getValidAmount();
        
        if (account.deposit(amount)) {
            System.out.printf("Updated Balance: ₹%.2f\n", account.getBalance());
        }
    }
    
    private void withdraw() {
        System.out.println();
        System.out.print("Enter withdrawal amount: ");
        
        double amount = getValidAmount();
        
        if (account.withdraw(amount)) {
            System.out.printf("Remaining Balance: ₹%.2f\n", account.getBalance());
        }
    }
    
    private double getValidAmount() {
        try {
            String input = scanner.nextLine();
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            return -1;
        }
    }
}
