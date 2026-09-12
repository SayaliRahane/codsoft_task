public class Main {
    
    public static void main(String[] args) {
        double initialBalance = 10000.00;
        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        
        System.out.println("Welcome to the ATM System!");
        System.out.printf("Initial Balance: ₹%.2f\n", initialBalance);
        System.out.println();
        
        atm.startATM();
    }
}
