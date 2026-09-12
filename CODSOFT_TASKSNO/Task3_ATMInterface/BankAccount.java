public class BankAccount {
    
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return false;
        }
        
        balance += amount;
        System.out.println("Deposit successful.");
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        
        balance -= amount;
        System.out.println("Withdrawal successful.");
        return true;
    }
    
    public double getBalance() {
        return balance;
    }
}
