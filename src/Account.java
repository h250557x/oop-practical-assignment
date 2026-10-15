
public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Concrete deposit method: rejects non-positive amounts
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited $%.2f. New balance: $%.2f%n", amount, balance);
    }

    // Concrete getBalance method
    public double getBalance() {
        return balance;
    }

    // Abstract withdraw method
    public abstract void withdraw(double amount);

    // Abstract endOfMonth hook method
    public abstract void endOfMonth();
}